package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaymentNotification extends AppCompatActivity {
    public static final String CHANNEL_1_ID = "paymentNotification";

    private NotificationManagerCompat notificationManager;
    private EditText paymentNotificationTextTitle;
    private EditText paymentNotificationDetailsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_notification);


        paymentNotificationTextTitle = findViewById(R.id.paymentNotificationText);
        paymentNotificationDetailsText = findViewById(R.id.paymentNotificationDetails);

        createNotificationChannel();

        notificationManager = NotificationManagerCompat.from(this);

        Button createNotificationButton = findViewById(R.id.createNotificationButton);

        createNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1(v);
            }
        });
    }

    public void createNotificationChannel(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
            NotificationChannel paymentNotification = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Payment Notification",
                    NotificationManager.IMPORTANCE_HIGH
            );
            paymentNotification.setDescription("Payment Notification");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(paymentNotification);
        }
    }

    public void sendOnChannel1(View v){
        String title = paymentNotificationTextTitle.getText().toString();
        String message = paymentNotificationDetailsText.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.payment_icon)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);

    }
}