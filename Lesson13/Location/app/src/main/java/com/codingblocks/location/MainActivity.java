package com.codingblocks.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener {

    public static final int LOCATION_PERMISSION_CODE = 12345;
    LocationManager locationManager;

    public static final String TAG = "MainActivity";
    TextView tvLat,tvLong,tvAltitude,tvSpeed,tvProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAltitude = findViewById(R.id.tvAltitude);
        tvLat = findViewById(R.id.tvLat);
        tvLong = findViewById(R.id.tvLong);
        tvSpeed = findViewById(R.id.tvSpeed);
        tvProvider = findViewById(R.id.tvProvider);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_DENIED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        == PackageManager.PERMISSION_DENIED) {

            //If the app does not have the required permissions, then request those permissions
            //This normally happens when the app was installed for the first time

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.CALL_PHONE},
                    LOCATION_PERMISSION_CODE);

        } else {
            //Check to see if the provider is enabled, thereby inferring if the user's location is enabled
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

                //Use this to get access to the last known location
//                Location lastKnownLocation = locationManager
//                        .getLastKnownLocation(LocationManager.GPS_PROVIDER);
//
//                Log.e(TAG, "onCreate: lastknown Lat" + lastKnownLocation.getLatitude() );
//                Log.e(TAG, "onCreate: lastknown Long" + lastKnownLocation.getLongitude() );

                //Use this for getting access to location only once
//                locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, this, null);

                //Use this to get access to location continuously
                locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        5000,
                        10,
                        this
                );
            } else {
                Toast.makeText(this, "Please enable the location in high accuracy mode", Toast.LENGTH_SHORT).show();
            }
        }
//        locationManager.removeUpdates(this);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOCATION_PERMISSION_CODE) {
            //Handle the result for location permission

            //Check to see if the permission was granted or not
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                //Location has been granted
                Toast.makeText(this, "Thank you for granting the permission", Toast.LENGTH_SHORT).show();
                //Use this to get access to location continuously
//                List<String> providers = locationManager.getProviders(true);
//
//                String bestProvider;
//
//                if (providers.contains(LocationManager.GPS_PROVIDER)){
//                    bestProvider = LocationManager.GPS_PROVIDER;
//                }else {
//                    bestProvider = LocationManager.NETWORK_PROVIDER;
//                }
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            5000, //time in milliseconds
                            10, //distance in meters
                            this //LocationListener callback
                    );
                } else {
                    Toast.makeText(this, "Please enable the location in high accuracy mode", Toast.LENGTH_SHORT).show();
                }
            } else {
                //Permission isn't granted, show another alertdialog to the user telling as to why you need the
                // permission
                Toast.makeText(this, "Please grant the location permission", Toast.LENGTH_SHORT).show();
//                finish();
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        //Called after every {minTime} milliseconds only when the device has travelled
        // the specified {minDistance} in meters
        tvLat.setText(""+location.getLatitude());
        tvLong.setText(""+location.getLongitude());
        tvSpeed.setText(""+location.getSpeed());
        tvAltitude.setText(""+location.getAltitude());
        tvProvider.setText(""+location.getProvider());

        Log.e(TAG, "onLocationChanged: " + location.getLongitude());
        Log.e(TAG, "onLocationChanged: " + location.getLatitude());
        Log.e(TAG, "onLocationChanged: " + location.getProvider());
        Log.e(TAG, "onLocationChanged: " + location.getAccuracy());
        Log.e(TAG, "onLocationChanged: " + location.getAltitude());
        Log.e(TAG, "onLocationChanged: " + location.getSpeed());
        Log.e(TAG, "onLocationChanged: " + location.getTime());
        Log.e(TAG, "onLocationChanged: " + location.getBearing());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        Log.e("TAG", "onProviderEnabled: " + s);
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.e("TAG", "onProviderDisabled: " + s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //When the app is no longer in use, simply unregister the listener
        locationManager.removeUpdates(this);
    }
}
