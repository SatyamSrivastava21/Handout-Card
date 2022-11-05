package com.satyam.handout_cards;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class donat extends AppCompatActivity implements PaymentResultListener {

    private EditText amountEdt;
    private Button payBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donat);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.donat);
        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), home.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.donat:
                        startActivity(new Intent(getApplicationContext(), donat.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), profile.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.shop:
                        startActivity(new Intent(getApplicationContext(), shopkeeper.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.contactus:
                        startActivity(new Intent(getApplicationContext(), contactus.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        // initializing all our variables.
        amountEdt = findViewById(R.id.idEdtAmount);
        payBtn = findViewById(R.id.idBtnPay);

        // adding on click listener to our button.
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // amount that is entered by user.
                String samount = amountEdt.getText().toString();

                // rounding off the amount.
                int amount = Math.round(Float.parseFloat(samount) * 100);

                // initialize Razorpay account.
                Checkout checkout = new Checkout();

                // set your id as below
                checkout.setKeyID("rzp_test_kCC2C4EXZSsNN1");

                // set image
                checkout.setImage(R.drawable.logo);

                // initialize json object
                JSONObject object = new JSONObject();
                try {
                    // to put name
                    object.put("name", "Thanks ");

                    // put description
                    object.put("description", "Test payment");

                    // to set theme color
                    object.put("theme.color", "#25383C");

                    // put the currency
                    object.put("currency", "INR");

                    // put amount
                    object.put("amount", amount);

                    // put mobile number
                    object.put("prefill.contact", "8005221202");

                    // put email
                    object.put("prefill.email", "abcd@gmail.com");

                    // open razorpay to checkout activity
                    checkout.open(donat.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        // this method is called on payment success.
        Toast.makeText(this, "Payment is successful : " + s, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "An mail will be send to your  registered email address . Thanks for donating  " + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        // on payment failed.
        Toast.makeText(this, "Payment Failed due to error : " + s, Toast.LENGTH_SHORT).show();
    }
}

