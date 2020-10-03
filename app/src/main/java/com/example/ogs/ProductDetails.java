package com.example.ogs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetails extends AppCompatActivity {

    ImageView img,add_cart ;
    TextView proName, proPrice, proDesc, proQty, proUnit;
    Button buy_btn;

    String name, price, desc, qty, unit;
    int image;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        buy_btn=findViewById(R.id.buy_btn);

        sharedPreferences = getSharedPreferences("product_pref", Context.MODE_PRIVATE);
        Intent i = getIntent();

         name = i.getStringExtra("name");
         image = i.getIntExtra("image", 0);
         price = i.getStringExtra("price");
         desc = i.getStringExtra("desc");
         qty = i.getStringExtra("qty");
         unit = i.getStringExtra("unit");

         add_cart=findViewById(R.id.add_cart);
         proName = findViewById(R.id.productName);
         proDesc = findViewById(R.id.prodDesc);
         proPrice = findViewById(R.id.prodPrice);
         img = findViewById(R.id.big_image);
         proQty = findViewById(R.id.qty);
         proUnit = findViewById(R.id.unit);

         proName.setText(name);
         proPrice.setText(price);
         proDesc.setText(desc);
         proQty.setText(qty);
         proUnit.setText(unit);
        img.setImageResource(image);
        buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",name);
                editor.putString("price",price);
                editor.putInt("img",image);
                editor.putString("qty",qty);
                editor.commit();
                editor.apply();

                Intent intent = new Intent(ProductDetails.this,Buy_productDetails.class);
                startActivity(intent);
                finish();


            }
        });
        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getApplicationContext().getSharedPreferences("cart",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name",name);
                editor.putString("price",price);
                editor.putString("qyt",qty);
                editor.putString("des",desc);
                editor.putInt("img",image);
                editor.commit();
                editor.apply();
                Toast.makeText(ProductDetails.this, "Product Added Cart", Toast.LENGTH_SHORT).show();

            }
        });



    }


   // this tutorial has been completed
    // see you in the next.
}
