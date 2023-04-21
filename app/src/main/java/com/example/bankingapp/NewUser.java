package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUser extends AppCompatActivity {
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_ADDRESS = "EXTRA_ADDRESS";
    public static final String EXTRA_EMAIL = "EXTRA_EMAIL";
    public static final String EXTRA_USERNAME = "EXTRA_USERNAME";
    public static final String EXTRA_PASSWORD = "EXTRA_PASSWORD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        Button submitNewUserButton = findViewById(R.id.submitNewUserButton);
        submitNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewUserInfo();

            }
        });
    }

    public void openNewUserInfo() {
        EditText enterFullName = findViewById(R.id.enterFullName);
        String fullName = enterFullName.getText().toString();

        EditText enterAddress = findViewById(R.id.enterAddress);
        String address = enterAddress.getText().toString();

        EditText enterEmail = findViewById(R.id.enterEmail);
        String email = enterEmail.getText().toString();

        EditText enterUsername = findViewById(R.id.enterUsername);
        String username = enterUsername.getText().toString();

        EditText enterPassword = findViewById(R.id.enterPassword);
        String password = enterPassword.getText().toString();

        Intent intent = new Intent(this, NewUserInfo.class);
        intent.putExtra(EXTRA_NAME, fullName);
        intent.putExtra(EXTRA_ADDRESS, address);
        intent.putExtra(EXTRA_EMAIL, email);
        intent.putExtra(EXTRA_USERNAME, username);
        intent.putExtra(EXTRA_PASSWORD, password);
        startActivity(intent);
    }


}