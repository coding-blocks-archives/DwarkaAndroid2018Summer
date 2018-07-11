package com.codingblocks.googlemaps;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    LatLng lastKnownLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        //Loads the map asynchronously
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //Modify map's UI settings

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                5000,
                25,
                this);

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(28, 77);
//
////        MarkerOptions markerOptions = new MarkerOptions();
////        markerOptions.position(sydney);
////        markerOptions.title("Hello from Sydney");
////        markerOptions.draggable(true);
//
//        MarkerOptions sydneyMarker = new MarkerOptions()
//                .position(sydney)
//                .title("Hello from sydney")
//                .draggable(true);
//
//        googleMap.addMarker(sydneyMarker);
//
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 20f));

//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng myCurrentLatLng = new LatLng(location.getLatitude(), location.getLongitude());

        if (lastKnownLocation == null){
            lastKnownLocation = myCurrentLatLng;
        }else {
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(myCurrentLatLng)
                    .title("My Current Location");

            mMap.addMarker(markerOptions);
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myCurrentLatLng, 15.0f));

        }

        //Removes all the markers
//        mMap.clear();

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
