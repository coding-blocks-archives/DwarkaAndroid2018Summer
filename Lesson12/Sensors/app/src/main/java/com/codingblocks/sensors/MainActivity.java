package com.codingblocks.sensors;

import android.app.ActivityManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.hardware.Sensor.TYPE_GRAVITY;
import static android.hardware.Sensor.TYPE_PROXIMITY;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView gravityX, gravityY, gravityZ;
    LinearLayout rootLayout;
    SensorManager sensorManager;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gravityX = findViewById(R.id.gravityX);
        gravityY = findViewById(R.id.gravityY);
        gravityZ = findViewById(R.id.gravityZ);

        rootLayout = findViewById(R.id.rootLayout);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> allSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        Log.e(TAG, "Number of Sensors : " + allSensors.size());

        for (Sensor s : allSensors) {

            Log.e(TAG, "onCreate: -------------------");

            Log.e(TAG, "onCreate: " + s.toString());

            Log.e(TAG, "onCreate: -------------------");

        }


//        sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] sensorValues = sensorEvent.values;
//        gravityX.setText("" + sensorValues[0]);
//        gravityY.setText("" + sensorValues[1]);
//        gravityZ.setText("" + sensorValues[2]);

        float red = Math.abs(sensorValues[0]);
        float green = Math.abs(sensorValues[1]);
        float blue = Math.abs(sensorValues[2]);

        int redColor = (int) ((red / SensorManager.GRAVITY_EARTH) * 255);
        int greenColor = (int) ((green / SensorManager.GRAVITY_EARTH) * 255);
        int blueColor = (int) ((blue / SensorManager.GRAVITY_EARTH) * 255);


        int color = Color.rgb(redColor, greenColor, blueColor);

        rootLayout.setBackgroundColor(color);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        Sensor gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        Sensor proximitySensor = sensorManager.getDefaultSensor(TYPE_PROXIMITY);

        //Register the Gravity sensor to listen for updates on it
        sensorManager.registerListener(this, gravitySensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }
}
