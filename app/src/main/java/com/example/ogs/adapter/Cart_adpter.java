package com.example.ogs.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ogs.CardActivity;
import com.example.ogs.ProductDetails;
import com.example.ogs.R;
import com.example.ogs.model.Search_model;

import java.util.List;

public class Cart_adpter extends RecyclerView.Adapter<Cart_adpter.Cart_holder> {
    Context context1;
    List<Search_model> search_modelList;

    public Cart_adpter(Context context, List<Search_model> search_modelList) {
        this.context1 = context;
        this.search_modelList = search_modelList;

    }

    @NonNull
    @Override
    public Cart_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context1).inflate(R.layout.cartitem_row,parent,false);
       return  new Cart_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cart_holder holder, final int position) {
        holder.search_img.setImageResource(search_modelList.get(position).getImageurl());
        holder.search_name.setText(search_modelList.get(position).getProducut_name());
        holder.search_price.setText(search_modelList.get(position).getPrice());
        holder.search_unit.setText(search_modelList.get(position).getProduct_unit());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context1, ProductDetails.class);
                i.putExtra("name",search_modelList.get(position).getProducut_name());
                i.putExtra("image",search_modelList.get(position).getImageurl());
                i.putExtra("price",search_modelList.get(position).getPrice());
                i.putExtra("qty",search_modelList.get(position).getProduct_unit());
                context1.startActivity(i);



            }
        });



    }

    @Override
    public int getItemCount() {
        return search_modelList.size();
    }

    public static class Cart_holder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
        ImageView search_img, popup;
        TextView search_name;
        TextView search_price;
        TextView search_unit;
        CardView rootview;


        public Cart_holder(@NonNull View itemView) {
            super(itemView);
            search_img = itemView.findViewById(R.id.cart_image);
            search_name = itemView.findViewById(R.id.cart_name);
            search_price = itemView.findViewById(R.id.cart_price);
            search_unit = itemView.findViewById(R.id.cart_unit);
            rootview = itemView.findViewById(R.id.rootview);
            popup = itemView.findViewById(R.id.popupmenu);
            popup.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            showpopup(v);
        }

        private void showpopup(View v) {
            PopupMenu popupMenu = new PopupMenu(v.getContext(),v);
            popupMenu.inflate(R.menu.cart_menu);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()){
                case R.id.remove:
                    Toast.makeText(itemView.getContext(), "Remove", Toast.LENGTH_SHORT).show();
                    return true;

            }
            return false;
        }
    }

}

