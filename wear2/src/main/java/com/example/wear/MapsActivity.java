package com.example.wear;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.view.DismissOverlayView;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

public class MapsActivity extends Activity implements OnMapReadyCallback,
        GoogleMap.OnMapLongClickListener {

    /**
     * Overlay that shows a short help text when first launched. It also provides an option to
     * exit the app.
     */
    private DismissOverlayView mDismissOverlay;

    /**
     * The map. It is initialized when the map has been fully loaded and is ready to be used.
     *
     * @see #onMapReady(com.google.android.gms.maps.GoogleMap)
     */
    private GoogleMap mMap;

    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        // Set the layout. It only contains a MapFragment and a DismissOverlay.
        setContentView(R.layout.activity_maps);

        // Retrieve the containers for the root of the layout and the map. Margins will need to be
        // set on them to account for the system window insets.
        final FrameLayout topFrameLayout = (FrameLayout) findViewById(R.id.root_container);
        final FrameLayout mapFrameLayout = (FrameLayout) findViewById(R.id.map_container);

        // Set the system view insets on the containers when they become available.
        topFrameLayout.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                // Call through to super implementation and apply insets
                insets = topFrameLayout.onApplyWindowInsets(insets);

                FrameLayout.LayoutParams params =
                        (FrameLayout.LayoutParams) mapFrameLayout.getLayoutParams();

                // Add Wearable insets to FrameLayout container holding map as margins
                params.setMargins(
                        insets.getSystemWindowInsetLeft(),
                        insets.getSystemWindowInsetTop(),
                        insets.getSystemWindowInsetRight(),
                        insets.getSystemWindowInsetBottom());
                mapFrameLayout.setLayoutParams(params);

                return insets;
            }
        });

        // Obtain the DismissOverlayView and display the introductory help text.
        mDismissOverlay = (DismissOverlayView) findViewById(R.id.dismiss_overlay);
        mDismissOverlay.setIntroText(R.string.intro_text);
        mDismissOverlay.showIntroIfNecessary();

        // Obtain the MapFragment and set the async listener to be notified when the map is ready.
        MapFragment mapFragment =
                (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Map is ready to be used.
        mMap = googleMap;

        // Set the long click listener as a way to exit the map.
        mMap.setOnMapLongClickListener(this);

        // Add a marker in Sydney, Australia and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        LatLng UC = new LatLng(-35.237493, 149.084132);
        LatLng parking = new LatLng(-35.241891, 149.084470);
        LatLng StudentCentre = new LatLng(-35.238969, 149.085033);
        LatLng ComputerDepartment = new LatLng(-35.238087, 149.085966);
        LatLng Library = new LatLng(-35.238007, 149.083349);
        LatLng GYM = new LatLng(-35.238593, 149.087263);

        mMap.addMarker(new MarkerOptions()
                .title("University of Canberra")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_uc))
                .snippet("Bruce campus")
                .position(UC)
                .draggable(true));

        mMap.addMarker(new MarkerOptions()
                .title("Parking")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_parking))
                .snippet("Causal Parking and E-Payment")
                .position(parking)
                .draggable(true));

        mMap.addMarker(new MarkerOptions()
                .title("Student Centre")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_stu))
                .snippet("Building 1")
                .position(StudentCentre)
                .draggable(true));

        mMap.addMarker(new MarkerOptions()
                .title("Computer Department")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_computer))
                .snippet("Building 11")
                .position(ComputerDepartment)
                .draggable(true));

        mMap.addMarker(new MarkerOptions()
                .title("Library")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_library))
                .snippet("building 8")
                .position(Library)
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .title("GYM")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_gym))
                .snippet("building 4")
                .position(GYM)
                .draggable(true));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UC, 14));

        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(-35.241806, 149.089985))  // Sydney
                .add(new LatLng(-35.242191, 149.089226))  // Fiji
                .add(new LatLng(-35.242309, 149.088311))  // Hawaii
                .add(new LatLng(-35.242358, 149.086956))
                .add(new LatLng(-35.242332, 149.086559))
                .add(new LatLng(-35.242332, 149.085609))
                .add(new LatLng(-35.242332, 149.082825))
                .add(new LatLng(-35.242345, 149.082712))
                .add(new LatLng(-35.242363, 149.077519))
                .add(new LatLng(-35.242293, 149.077447))
                .add(new LatLng(-35.242095, 149.076602))
                .add(new LatLng(-35.240973, 149.074848))
                .add(new LatLng(-35.240890, 149.074982))
                .add(new LatLng(-35.240775, 149.075088))
                .add(new LatLng(-35.237853, 149.077132))
                .add(new LatLng(-35.236609, 149.077389))
                .add(new LatLng(-35.234654, 149.078206))
                .add(new LatLng(-35.232929, 149.079469))
                .add(new LatLng(-35.232254, 149.080081))
                .add(new LatLng(-35.231325, 149.080542))
                .add(new LatLng(-35.231286, 149.081309))
                .add(new LatLng(-35.232149, 149.084370))
                .add(new LatLng(-35.233945, 149.087610))
                .add(new LatLng(-35.234813, 149.091387))
                .add(new LatLng(-35.234975, 149.091562))
                .add(new LatLng(-35.235178, 149.091527))
                .add(new LatLng(-35.235274, 149.091559))
                .add(new LatLng(-35.238928, 149.090229))
                .add(new LatLng(-35.240234, 149.089961))
                .add(new LatLng(-35.241806, 149.089985))
                .width(5)// Mountain View


        );
        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(-35.241520, 149.084910),
                        new LatLng(-35.241222, 149.084899),
                        new LatLng(-35.241208, 149.085286),
                        new LatLng(-35.239329, 149.085232),
                        new LatLng(-35.238798, 149.085347),
                        new LatLng(-35.238802, 149.085018)
                )
                .width(5)
                .color(Color.BLUE)
                .geodesic(true));
        Polyline line1 = mMap.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(-35.238798, 149.085347),
                        new LatLng(-35.238601, 149.085309),
                        new LatLng(-35.238179, 149.085549)
                )
                .width(5)
                .color(Color.RED)
                .geodesic(true));
        Polyline line2 = mMap.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(-35.238802, 149.085018),
                        new LatLng(-35.238803, 149.084226),
                        new LatLng(-35.238164, 149.084233),
                        new LatLng(-35.238162, 149.083654)
                )
                .width(5)
                .color(Color.GREEN)
                .geodesic(true));
        Polyline line3 = mMap.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(-35.238164, 149.084233),
                        new LatLng(-35.237493, 149.084132)

                )
                .width(5)
                .color(Color.YELLOW)
                .geodesic(true));
        Polyline line4 = mMap.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(-35.238179, 149.085549),
                        new LatLng(-35.238237, 149.087161),
                        new LatLng(-35.238400, 149.087160)

                )
                .width(5)
                .color(Color.BLACK)
                .geodesic(true));
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        // Display the dismiss overlay with a button to exit this activity.
        mDismissOverlay.show();
    }
    public void streetView(View view)
    {
        Intent intent = new Intent(this, StreetView.class);
        startActivity(intent);

    }
    public void streetView1(View view)
    {
        Intent intent = new Intent(this, StreetView1.class);
        startActivity(intent);

    }
}
