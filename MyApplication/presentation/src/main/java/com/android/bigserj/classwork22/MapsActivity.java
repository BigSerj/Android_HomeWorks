package com.android.bigserj.classwork22;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.android.bigserj.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork22map);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map4);
        mapFragment.getMapAsync(this);

        Button stand = (Button) findViewById(R.id.buttonStandard);
        Button hybrid = (Button) findViewById(R.id.buttonHybrid);
        Button satellite = (Button) findViewById(R.id.buttonSatellite);
        Button local = (Button) findViewById(R.id.buttonLocal);
        Button none = (Button) findViewById(R.id.buttonNone);

        stand.setOnClickListener(this);
        hybrid.setOnClickListener(this);
        satellite.setOnClickListener(this);
        local.setOnClickListener(this);
        none.setOnClickListener(this);

        Button vitebskB = (Button) findViewById(R.id.vitebsk);
        Button grodnoB = (Button) findViewById(R.id.grodno);
        Button mogilevB = (Button) findViewById(R.id.mogilev);
        Button brestB = (Button) findViewById(R.id.brest);
        Button gomelB = (Button) findViewById(R.id.gomel);

        vitebskB.setOnClickListener(this);
        grodnoB.setOnClickListener(this);
        mogilevB.setOnClickListener(this);
        brestB.setOnClickListener(this);
        gomelB.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStandard:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.buttonHybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.buttonSatellite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.buttonLocal:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.buttonNone:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;

            case R.id.vitebsk:
                printLine(55.188841F, 30.198842F);
                break;
            case R.id.grodno:
                printLine(53.684049F, 23.826771F);
                break;
            case R.id.mogilev:
                printLine(53.905207F, 30.330678F);
                break;
            case R.id.brest:
                printLine(52.109698F, 23.705922F);
                break;
            case R.id.gomel:
                printLine(52.453344F, 31.006337F);
                break;
        }
    }


    private void printLine(float lat, float lon) {

        PolylineOptions firstOptions5 = new PolylineOptions()
                .add(new LatLng(53.895475, 27.556630))
                .add(new LatLng(lat,lon));
        mMap.addPolyline(firstOptions5);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(55.188841, 30.198842))
                .title("Витебск"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(53.684049, 23.826771))
                .title("Гродно"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(53.905207, 30.330678))
                .title("Могилев"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(52.109698, 23.705922))
                .title("Брест"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(52.453344, 31.006337))
                .title("Гродно"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(53.895475, 27.556630))
                .title("Минск"));


        // Add a marker in Sydney and move the camera
        LatLng minsk = new LatLng(53.895475, 27.556630);
        mMap.addMarker(new MarkerOptions().position(minsk).title("This is Minsk, baby"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(minsk));
    }


}
