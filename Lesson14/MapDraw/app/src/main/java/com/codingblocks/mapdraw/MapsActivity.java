package com.codingblocks.mapdraw;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;

    LatLng lastKnownLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        int fillColor = Color.rgb(255, 0, 0);
        int strokeColor = Color.rgb(255, 255, 255);

        LatLng sydney = new LatLng(-34, 151);

        LatLng delhi = new LatLng(28,77);

        LatLng antarctica = new LatLng(-80,180);

        //Draws a circle on the map
        CircleOptions circleOptions = new CircleOptions()
                .radius(10000)
                .center(sydney)
                .fillColor(fillColor)
                .strokeColor(strokeColor)
                .strokeWidth(10f)
                .clickable(true);

        mMap.addCircle(circleOptions);

        //Draws a line on the map
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(sydney,delhi,antarctica);

        mMap.addPolyline(polylineOptions);

        //Draws a closed shape on the map
        PolygonOptions polygonOptions = new PolygonOptions()
                .add(sydney,delhi,antarctica);

        mMap.addPolygon(polygonOptions);

        mMap.setOnMarkerDragListener(this);

        lastKnownLocation = sydney;

        //addMarker method returns a Marker object which can be stored to remove the marker later
        Marker marker = mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").draggable(true));
//        marker.remove();

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        LatLng currentPosition = lastKnownLocation;

        MarkerOptions markerOptions = new MarkerOptions().position(currentPosition).title("New Title");

        mMap.addMarker(markerOptions);
    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(lastKnownLocation,marker.getPosition());

        mMap.addPolyline(polylineOptions);

        lastKnownLocation = marker.getPosition();
    }
}
