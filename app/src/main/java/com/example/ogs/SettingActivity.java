package com.example.ogs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.example.ogs.model.Setting_class;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        if (findViewById(R.id.fragmentcontainer)!=null)
        {
            if (savedInstanceState!=null)
                return;
            getFragmentManager().beginTransaction().add(R.id.fragmentcontainer,new Setting_class()).commit();


        }

    }
}
