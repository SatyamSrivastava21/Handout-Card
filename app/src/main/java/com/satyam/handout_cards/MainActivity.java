package com.satyam.handout_cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String url1 = "https://imgs.search.brave.com/Ce36ulACtrV9SwSgDQDRMF18jVzOnVkBfG99IXzon_g/rs:fit:791:225:1/g:ce/aHR0cHM6Ly90c2Uz/Lm1tLmJpbmcubmV0/L3RoP2lkPU9JUC5i/b1JDcEJrMnBGdUxP/bF9xLURlQlV3SGFF/YyZwaWQ9QXBp";
    String url2 = "https://loveachild.com/wp-content/uploads/2014/05/Haitian-boy-2-with-food.png";
    String url3 = "https://faresharesouthwest.org.uk/wp-content/uploads/2019/11/dtpg-charity-56-scaled.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // new Handler().postDelayed(() -> startActivity(new Intent(MainActivity.this,home.class)), 2000);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent iNext;
            Animation anim1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim1);
            button.startAnimation(anim1);
            iNext = new Intent(this, regi.class);
            startActivity(iNext);
        });
        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
    }
}
