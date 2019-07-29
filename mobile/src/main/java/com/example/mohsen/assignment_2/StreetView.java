package com.example.mohsen.assignment_2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.StreetViewPanorama;


public class StreetView extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {

    static final LatLng UC = new LatLng(-35.242208, 149.085303);
    private static final float ZOOM_BY = -1.0f;
    long duration = 5000;
    float tilt = 0;
    private static final int PAN_BY = 180;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {

        // Animate over a duration of 5000 milliseconds.
        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .zoom(panorama.getPanoramaCamera().zoom + ZOOM_BY)
                .bearing(panorama.getPanoramaCamera().bearing - PAN_BY)
                .tilt(tilt)
                .build();

        panorama.animateTo(camera, duration);
        panorama.setPosition(UC);


    }


}
