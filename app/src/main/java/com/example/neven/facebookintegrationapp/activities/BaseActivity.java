package com.example.neven.facebookintegrationapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.neven.facebookintegrationapp.MyApplication;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getApplication()).getAppComponent().inject(this);
    }
}
