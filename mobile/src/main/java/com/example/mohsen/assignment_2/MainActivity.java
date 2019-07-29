package com.example.mohsen.assignment_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;
    MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        switch (item.getItemId()){
            case R.id.streetView:
                Intent intent = new Intent(this, StreetView.class);
                startActivity(intent);
                break;
            case R.id.streetView1:
                Intent intent1 = new Intent(this, StreetView2.class);
                startActivity(intent1);
                break;
            case R.id.mapTypeNone:
                map.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
            case R.id.mapTypeSatellite:
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.mapTypeHybrid:
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.mapTypeTerrain:
                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.mapTypeNormal:
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    public void mapCreate(GoogleMap googleMap)
    {
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        return;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //map = googleMap;
        //map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mapCreate(googleMap);
        LatLng UC = new LatLng(-35.237493, 149.084132);
        LatLng parking = new LatLng(-35.241891, 149.084470);
        LatLng StudentCentre = new LatLng(-35.238969, 149.085033);
        LatLng ComputerDepartment = new LatLng(-35.238087, 149.085966);
        LatLng Library = new LatLng(-35.238007, 149.083349);
        LatLng GYM = new LatLng(-35.238593, 149.087263);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(UC, 15));

        map.addMarker(new MarkerOptions()
                .title("University of Canberra")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_uc))
                .snippet("Bruce campus")
                .position(UC)
                .draggable(true));

        map.addMarker(new MarkerOptions()
                .title("Parking")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
                .snippet("Causal Parking and E-Payment")
                .position(parking)
                .draggable(true));

        map.addMarker(new MarkerOptions()
                .title("Student Centre")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_stu))
                .snippet("Building 1")
                .position(StudentCentre)
                .draggable(true));

        map.addMarker(new MarkerOptions()
                .title("Computer Department")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_computer))
                .snippet("Building 11")
                .position(ComputerDepartment)
                .draggable(true));

        map.addMarker(new MarkerOptions()
                .title("Library")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_library))
                .snippet("building 8")
                .position(Library)
                .draggable(true));
        map.addMarker(new MarkerOptions()
                .title("GYM")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_gym))
                .snippet("building 4")
                .position(GYM)
                .draggable(true));

        map.addPolyline(new PolylineOptions().geodesic(true)
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
        );

        Polyline line = map.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(-35.241520, 149.084910),
                        new LatLng(-35.241222, 149.084899),
                        new LatLng(-35.241208, 149.085286),
                        new LatLng(-35.239329, 149.085232),
                        new LatLng(-35.238798, 149.085347),
                        new LatLng(-35.238802, 149.085018)
                )
                .width(12)
                .color(Color.BLUE)
                .geodesic(true));
        Polyline line1 = map.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(-35.238798, 149.085347),
                        new LatLng(-35.238601, 149.085309),
                        new LatLng(-35.238179, 149.085549)
                )
                .width(12)
                .color(Color.RED)
                .geodesic(true));
        Polyline line2 = map.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(-35.238802, 149.085018),
                        new LatLng(-35.238803, 149.084226),
                        new LatLng(-35.238164, 149.084233),
                        new LatLng(-35.238162, 149.083654)
                )
                .width(12)
                .color(Color.GREEN)
                .geodesic(true));
        Polyline line3 = map.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(-35.238164, 149.084233),
                        new LatLng(-35.237493, 149.084132)

                )
                .width(12)
                .color(Color.YELLOW)
                .geodesic(true));
        Polyline line4 = map.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(-35.238179, 149.085549),
                        new LatLng(-35.238237, 149.087161),
                        new LatLng(-35.238400, 149.087160)

                )
                .width(12)
                .color(Color.BLACK)
                .geodesic(true));


    }

}
