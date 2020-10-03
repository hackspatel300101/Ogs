package com.example.ogs.model;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.ogs.R;


public class Setting_class extends PreferenceFragment {

    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.prefrencescreen);

    }
}
