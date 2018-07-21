package com.codingblocks.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "myChannelId";
    int count = 94944840;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "My Awesome Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(notificationChannel);

        }

        final Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Hi I'm a notfication")
                .setContentText("Welcome to Coding Blocks!")
                .build();


        Button btnNotification = findViewById(R.id.simpleNotification);

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                notificationManager.notify(count, notification);
                //Show the notification here

            }
        });

    }

    public void showExpandableText(View view) {

        final Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Hi I'm a notfication")
                .setContentText("Welcome to Coding Blocks!")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(
                        "Welcome to CB, hope you enjoy your stay here with us! Happy Learning."
                ))
                .build();

        count++;
        notificationManager.notify(count, notification);

    }

    public void showExpandableImage(View view) {

        final Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Hi I'm a notfication")
                .setContentText("Welcome to Coding Blocks!")
                .build();

        count++;
        notificationManager.notify(count, notification);
    }

    public void showInboxStyle(View view) {

        final Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Hi I'm a notfication")
                .setContentText("Welcome to Coding Blocks!")
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Line 1")
                        .addLine("Line 2")
                        .addLine("Line 3")
                        .addLine("Line 4"))
                .build();

        count++;
        notificationManager.notify(count, notification);

    }
}
