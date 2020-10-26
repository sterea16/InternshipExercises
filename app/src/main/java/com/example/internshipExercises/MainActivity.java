package com.example.internshipExercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapView mapView = findViewById(R.id.maps);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        mapView.onResume();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng coordinates = new LatLng(46.768150,23.570607);
        googleMap.addMarker(new MarkerOptions().position(coordinates));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 16f));
        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.setTitle(getResources().getString(R.string.marker_title));
                return false;
            }
        });
    }
}
