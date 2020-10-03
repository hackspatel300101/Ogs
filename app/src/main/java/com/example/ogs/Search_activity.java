package com.example.ogs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.ogs.adapter.Search_Adpter;
import com.example.ogs.model.Search_model;


import java.util.ArrayList;
import java.util.List;

public class Search_activity extends AppCompatActivity {
    EditText search;
    RecyclerView recyclerView;
    Search_Adpter search_adpter;
    List<Search_model> search_modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);
        search = findViewById(R.id.search_edit);
        recyclerView=findViewById(R.id.search_all);

        search_modelList=new ArrayList<>();
        search_modelList.add(new Search_model(1,R.drawable.kevi,"kevi","30","1 peice","Vitamin c etc"));
        search_modelList.add(new Search_model(1,R.drawable.watermalon,"Watermalon","40","1 kg","Fruit"));
        search_modelList.add(new Search_model(1,R.drawable.moongdal,"Moong Dal","40","1kg","kathod"));
        search_modelList.add(new Search_model(1,R.drawable.coke,"Coke","40","250ml","soda,Alcohole"));
        search_modelList.add(new Search_model(1,R.drawable.atta,"Atta","50","1kg","Gehu Ataa"));
        search_modelList.add(new Search_model(1,R.drawable.vatana,"Vatana","35","1kg","kathod"));
        setRecycler(search_modelList);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });


    }
    private void filter(String toString) {
        ArrayList<Search_model> filterlist = new ArrayList<>();
        for (Search_model Item: search_modelList){
            if (Item.getProducut_name().toLowerCase().contains(toString.toLowerCase())){
                filterlist.add(Item);
            }

        }
        search_adpter.filtter_list(filterlist);
    }

    public void setRecycler(List<Search_model> datalist){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        search_adpter= new Search_Adpter(this,datalist);
        recyclerView.setAdapter(search_adpter);
    }

}
