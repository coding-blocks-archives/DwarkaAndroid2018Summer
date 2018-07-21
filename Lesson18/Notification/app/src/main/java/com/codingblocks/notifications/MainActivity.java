package com.codingblocks.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
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

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("KEY", "VALUE");

        PendingIntent pi = PendingIntent.getActivity(this,
                420,
                i,
                PendingIntent.FLAG_UPDATE_CURRENT);


        final Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Hi I'm a notfication")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .addAction(R.drawable.ic_android_black, "Reply", pi)
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

        String appName = getString(R.string.app_name);

        //Most of the methods which are available on only higher APIs
        //have backward compatibility added via ContextCompat class

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_umbrella);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_umbrella);

        final Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Hi I'm a notfication")
                .setContentText("Welcome to Coding Blocks!")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap))
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
