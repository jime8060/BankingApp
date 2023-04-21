package com.example.bankingapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoanCalc extends AppCompatActivity {
    private TextView monthlyPay;
    private EditText editPercentage;
    private EditText loanAmount;
    private Button main2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calc);
    }

    public void twoYear(View v){
        EditText editPercentage = (EditText) findViewById(R.id.editPercentage);
        EditText editLoanAmount = (EditText) findViewById(R.id.editLoanAmount);
        TextView monthlyPay = (TextView) findViewById(R.id.monthlyPay);

        float num1 = Float.parseFloat(editPercentage.getText().toString());
        int num2 = Integer.parseInt(editLoanAmount.getText().toString());
        float result = num2 * (num1/24);

        monthlyPay.setText("Monthly payment: " + result);
    }

    public void threeYear(View v){
        EditText editPercentage = (EditText) findViewById(R.id.editPercentage);
        EditText editLoanAmount = (EditText) findViewById(R.id.editLoanAmount);
        TextView monthlyPay = (TextView) findViewById(R.id.monthlyPay);

        float num1 = Float.parseFloat(editPercentage.getText().toString());
        int num2 = Integer.parseInt(editLoanAmount.getText().toString());
        float result = num2 * (num1/36);

        monthlyPay.setText("Monthly payment: " + result);
    }
}