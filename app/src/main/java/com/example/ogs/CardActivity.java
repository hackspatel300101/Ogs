package com.example.ogs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ogs.adapter.Cart_adpter;
import com.example.ogs.adapter.Search_Adpter;
import com.example.ogs.model.Search_model;

import java.util.ArrayList;
import java.util.List;


public class CardActivity extends AppCompatActivity {

    RecyclerView recyclerView;
   Cart_adpter cart_adpter;
    List<Search_model> search_modelList;
    String price,name,desc,qyt;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        recyclerView=findViewById(R.id.cart_recyleview);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        SharedPreferences preferences = getSharedPreferences("cart",MODE_PRIVATE);
        price=preferences.getString("price",null);
        name=preferences.getString("name",null);
        desc=preferences.getString("des",null);
        qyt=preferences.getString("qyt",null);
        img=preferences.getInt("img",0);
        search_modelList=new ArrayList<>();
        search_modelList.add(new Search_model(1,img,name,price,qyt,desc));
        setRecycler(search_modelList);





    }

    public void setRecycler(List<Search_model> datalist){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        cart_adpter= new Cart_adpter(this,datalist);
        recyclerView.setAdapter(cart_adpter);
    }





    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();

        }
        return super.onOptionsItemSelected(item);
    }

}
