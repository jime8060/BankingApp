package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void twoYear(View v){
        EditText textView = (EditText) findViewById(R.id.textView);
        EditText textView2 = (EditText) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);

        int num1 = Integer.parseInt(textView.getText().toString());
        float num2 = Float.parseFloat(textView2.getText().toString());
        float result = num1 * (num2/24);

        textView3.setText("Monthly payment: " + result);
    }

    public void threeYear(View v){
        EditText textView = (EditText) findViewById(R.id.textView);
        EditText textView2 = (EditText) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);

        int num1 = Integer.parseInt(textView.getText().toString());
        float num2 = Float.parseFloat(textView2.getText().toString());
        float result = num1 * (num2/36);

        textView3.setText("Monthly payment: " + result);
    }
}