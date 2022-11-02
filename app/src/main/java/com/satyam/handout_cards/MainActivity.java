package com.satyam.handout_cards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;

import android.os.Handler;

import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(() -> startActivity(new Intent(MainActivity.this, home.class)), 500);
    }
}
