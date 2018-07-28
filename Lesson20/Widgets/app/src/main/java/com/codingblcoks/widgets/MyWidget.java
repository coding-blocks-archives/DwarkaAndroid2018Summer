package com.codingblcoks.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class MyWidget extends AppWidgetProvider {

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);


    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {

            Log.e("TAG", "onUpdate: " + appWidgetId );

            Integer random = new Random().nextInt(1000);
            RemoteViews widgetView = new RemoteViews(context.getPackageName(), R.layout.my_widget);
            widgetView.setTextViewText(R.id.appwidget_text, random.toString());

            Intent updateWidgt = new Intent();
            updateWidgt.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            updateWidgt.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,appWidgetIds);

//            Intent i = new Intent(context,MainActivity.class);

            PendingIntent pi = PendingIntent.getBroadcast(context,99999,updateWidgt,PendingIntent.FLAG_UPDATE_CURRENT);

            widgetView.setOnClickPendingIntent(R.id.relativeLayout,pi);

            appWidgetManager.updateAppWidget(appWidgetId,widgetView);

        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

