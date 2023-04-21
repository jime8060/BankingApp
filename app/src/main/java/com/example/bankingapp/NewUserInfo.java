package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewUserInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_info);

        Intent intent = getIntent();
        String fullName = intent.getStringExtra(NewUser.EXTRA_NAME);
        String address = intent.getStringExtra(NewUser.EXTRA_ADDRESS);
        String email = intent.getStringExtra(NewUser.EXTRA_EMAIL);
        String username = intent.getStringExtra(NewUser.EXTRA_USERNAME);
        String password = intent.getStringExtra(NewUser.EXTRA_PASSWORD);

        TextView showFullName = findViewById(R.id.showFullName);
        TextView showAddress = findViewById(R.id.showAddress);
        TextView showEmail = findViewById(R.id.showEmail);
        TextView showUsername = findViewById(R.id.showUsername);
        TextView showPassword = findViewById(R.id.showPassword);

        showFullName.setText(fullName);
        showAddress.setText(address);
        showEmail.setText(email);
        showUsername.setText(username);
        showPassword.setText(password);


    }

}