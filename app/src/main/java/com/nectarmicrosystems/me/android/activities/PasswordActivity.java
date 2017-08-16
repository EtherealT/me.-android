package com.nectarmicrosystems.me.android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nectarmicrosystems.me.R;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        getSupportActionBar().hide();
    }
}
