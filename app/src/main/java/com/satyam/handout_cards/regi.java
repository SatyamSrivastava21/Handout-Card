package com.satyam.handout_cards;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.view.WindowManager;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

public class regi extends AppCompatActivity {

    private EditText etName, etEmail, etPassword;
    private TextView tvNameError, tvEmailError, tvPasswordError, tvColor;
    private CardView frameOne, frameTwo, frameThree, frameFour;
    private CardView btnRegister;
    private boolean isAtLeast8 = false, hasUppercase = false, hasNumber = false, hasSymbol = false, isRegistrationClickable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regi);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tvColor = findViewById(R.id.tvColor);
        tvNameError = findViewById(R.id.tvNameError);
        tvEmailError = findViewById(R.id.tvEmailError);
        tvPasswordError = findViewById(R.id.tvPasswordError);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        frameOne = findViewById(R.id.frameOne);
        frameTwo = findViewById(R.id.frameTwo);
        frameThree = findViewById(R.id.frameThree);
        frameFour = findViewById(R.id.frameFour);
        btnRegister = findViewById(R.id.btnRegister);

        findViewById(R.id.btnRegister).setOnClickListener(v -> {
            Intent iNext;
            iNext = new Intent(regi.this,home.class);
            startActivity(iNext);
            String name = etName.getText().toString(), email = etEmail.getText().toString(), password = etPassword.getText().toString();

            if (name.length() > 0 && email.length() > 0 && password.length() > 0) {
                if (isRegistrationClickable) {
                    Toast.makeText(regi.this, "REGISTRATION", Toast.LENGTH_LONG).show();
                }
            } else {
                if (name.length() == 0) {
                    tvNameError.setVisibility(View.VISIBLE);
                }
                if (email.length() == 0) {
                    tvEmailError.setVisibility(View.VISIBLE);
                }
                if (password.length() == 0) {
                    tvPasswordError.setVisibility(View.VISIBLE);
                }
            }
        });
        inputChange();
    }

    private void checkEmpty(String name, String email, String password) {
        if (name.length() > 0 && tvNameError.getVisibility() == View.VISIBLE) {
            tvNameError.setVisibility(View.GONE);
        }
        if (password.length() > 0 && tvPasswordError.getVisibility() == View.VISIBLE) {
            tvPasswordError.setVisibility(View.GONE);
        }
        if (email.length() > 0 && tvEmailError.getVisibility() == View.VISIBLE) {
            tvEmailError.setVisibility(View.GONE);
        }
    }

    @SuppressLint("ResourceType")
    private void checkAllData(String email) {
        if (isAtLeast8 && hasUppercase && hasNumber && hasSymbol && email.length() > 0) {
            isRegistrationClickable = true;
            tvColor.setTextColor(Color.WHITE);
            btnRegister.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            isRegistrationClickable = false;
            btnRegister.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }
    }

    @SuppressLint("ResourceType")
    private void registrationDataCheck() {
        String password = etPassword.getText().toString(), email = etEmail.getText().toString(), name = etName.getText().toString();

        checkEmpty(name, email, password);

        if (password.length() >= 8) {
            isAtLeast8 = true;
            frameOne.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            isAtLeast8 = false;
            frameOne.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }
        if (password.matches("(.*[A-Z].*)")) {
            hasUppercase = true;
            frameTwo.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            hasUppercase = false;
            frameTwo.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }
        if (password.matches("(.*[0-9].*)")) {
            hasNumber = true;
            frameThree.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            hasNumber = false;
            frameThree.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }
        if (password.matches("^(?=.*[_.()]).*$")) {
            hasSymbol = true;
            frameFour.setCardBackgroundColor(Color.parseColor(getString(R.color.colorAccent)));
        } else {
            hasSymbol = false;
            frameFour.setCardBackgroundColor(Color.parseColor(getString(R.color.colorDefault)));
        }

        checkAllData(email);
    }

    private void inputChange() {
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                registrationDataCheck();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                registrationDataCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
    }
}

