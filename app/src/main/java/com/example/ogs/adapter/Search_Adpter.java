package com.example.ogs.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ogs.ProductDetails;
import com.example.ogs.R;
import com.example.ogs.model.Search_model;

import java.util.ArrayList;
import java.util.List;

public class Search_Adpter extends RecyclerView.Adapter<Search_Adpter.Seach_Adpter_holder> {
    Context context;
    List<Search_model> search_modelList;

    public Search_Adpter(Context context, List<Search_model> search_modelList) {
        this.context = context;
        this.search_modelList = search_modelList;

    }

    @NonNull
    @Override
    public Seach_Adpter_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.price_list_view, parent, false);

        return new Seach_Adpter_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Seach_Adpter_holder holder, final int position) {
        holder.search_img.setImageResource(search_modelList.get(position).getImageurl());
        holder.search_name.setText(search_modelList.get(position).getProducut_name());
        holder.search_price.setText(search_modelList.get(position).getPrice());
        holder.search_unit.setText(search_modelList.get(position).getProduct_unit());
        holder.search_des.setText(search_modelList.get(position).getProduct_des());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ProductDetails.class);
                i.putExtra("name",search_modelList.get(position).getProducut_name());
                i.putExtra("image",search_modelList.get(position).getImageurl());
                i.putExtra("price",search_modelList.get(position).getPrice());
                i.putExtra("qty",search_modelList.get(position).getProduct_unit());
                i.putExtra("desc",search_modelList.get(position).getProduct_des());
                context.startActivity(i);



            }
        });


    }

    @Override
    public int getItemCount() {
        return search_modelList.size();
    }

    public void filtter_list(ArrayList<Search_model> filterlist) {
        search_modelList=filterlist;
        notifyDataSetChanged();
    }

    public  static class Seach_Adpter_holder extends RecyclerView.ViewHolder{

        ImageView search_img;
        TextView search_name;
        TextView search_price;
        TextView search_unit;
        TextView search_des;

        public Seach_Adpter_holder(@NonNull View itemView) {
            super(itemView);

            search_img = itemView.findViewById(R.id.search_image);
            search_name=itemView.findViewById(R.id.search_name);
            search_price=itemView.findViewById(R.id.search_price);
            search_unit=itemView.findViewById(R.id.search_unit);
            search_des=itemView.findViewById(R.id.search_description);

        }
    }
}