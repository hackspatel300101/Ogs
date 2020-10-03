package com.example.ogs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Buy_productDetails extends AppCompatActivity {
    TextView pro_name,pro_qyt,pro_total;
    ImageView  pro_img;
    EditText address;
    Button buy_btn;
    int pro_img1;
    String loc,pro_name1,pro_qty1,pro_price1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product_details);
        pro_img =findViewById(R.id.final_photo);
        pro_name=findViewById(R.id.final_name);
        pro_qyt=findViewById(R.id.final_qyt);
        pro_total=findViewById(R.id.final_total);
        address=findViewById(R.id.name_address);
        buy_btn=findViewById(R.id.buy_final);
        SharedPreferences preferen = getSharedPreferences("product_pref",MODE_PRIVATE);
        pro_name1=preferen.getString("name",null);
        pro_qty1=preferen.getString("qty",null);
        pro_price1=preferen.getString("price",null);
        pro_img1=preferen.getInt("img",0);
        pro_img.setImageResource(pro_img1);
        pro_name.setText(pro_name1);
        pro_qyt.setText(pro_qty1);
        pro_total.setText(pro_price1);
        SharedPreferences preferences = getSharedPreferences("my_pref",MODE_PRIVATE);
        loc=preferences.getString("loc",null);
        address.setText(loc);



    }
}
