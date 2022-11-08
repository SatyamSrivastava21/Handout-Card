package com.satyam.handout_cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       Button button = findViewById(R.id.button);
       button.setOnClickListener(view -> {
            Intent iNext;
           Animation anim1 = AnimationUtils.loadAnimation(splash.this,R.anim.anim1);
           button.startAnimation(anim1);
            iNext = new Intent(splash.this,MainActivity.class);
            startActivity(iNext);
        });
    }
}