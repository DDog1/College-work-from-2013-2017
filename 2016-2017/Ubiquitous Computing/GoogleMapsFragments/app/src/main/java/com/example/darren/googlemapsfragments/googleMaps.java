package com.example.darren.googlemapsfragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by darren on 02/11/2016.
 */

public class googleMaps extends AppCompatActivity implements OnMapReadyCallback {

    String city = "";
    MapFragment mf;
    GoogleMap map;
    double lat, lon;
    Location location = null;

    public void setCity(String city) {
        this.city = city;
    }

    public void showMap() {
        mf = (MapFragment) getFragmentManager().findFragmentById(R.id.the_map);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // CityMapFragment (Fragment B) is not in the layout (handset layout),
            // so start MapActivity (Activity B)
            // and pass it the info about the selected item
            Intent intent = new Intent(this, googleMapsActivity.class);
            intent.putExtra("city", city);
            startActivity(intent);
        } else {
            // CityMApFragment (Fragment B) is in the layout (tablet layout)
            mf.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {    // map is loaded but not laid out yet
        this.map = map;
        // code to run when the map has loaded

        if (city.equals("Dublin")) {
            lat = 53.347860;
            lon = -6.272487;
        } else if (city.equals("Cork")) {
            lat = 51.892171;
            lon = -8.475068;
        } else if (city.equals("Kerry")) {
            lat = 52.264007;
            lon = -9.686990;
        } else if (city.equals("Belfast")) {
            lat = 54.602755;
            lon = -5.945180;
        } else if (city.equals("Galway")) {
            lat = 53.276533;
            lon = -9.069362;
        } else if (city.equals("Wexford")) {
            lat = 52.336521;
            lon = -6.462855;
        } else if (city.equals("Current Location")) {
            //************************************************
            //****************** TEST CODE *******************
            //************************************************
/*
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                map.setMyLocationEnabled(true);
            } else {
                // Show rationale and request permission.
                toast = Toast.makeText(getApplicationContext(), "Do not have the permission to get your location", Toast.LENGTH_SHORT);
                toast.show();
            }
*/
            //************************************************
            //******************* GPS CODE *******************
            //************************************************
            LocationManager locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
            LocationListener locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location loc) {
                    makeUseOfThisLocation(loc);
                }
                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) { }
                @Override
                public void onProviderEnabled(String provider) { }
                @Override
                public void onProviderDisabled(String provider) { }
            };
            try {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                double testlat, testlon;
                testlat = location.getLatitude();
                testlon = location.getLongitude();
                Log.e("Location","TEST Lon = "+testlon);
                Log.e("Location","TEST Lat = "+testlat);
                lat = testlat;
                lon = testlon;

            } catch (SecurityException ex) {
                ex.printStackTrace();
            }
            //************************************************
            //******************* GPS CODE *******************
            //************************************************
        } else {
            lat=0;
            lon=0;
        }

        Log.e("Location","Lon = "+lon);
        Log.e("Location","Lat = "+lat);
        map.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lon))
                .title(""+city)
                .snippet("lat : "+lat+" lon : "+lon)
        );

        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lon)));
        map.moveCamera(CameraUpdateFactory.zoomTo(10));

    }
    //************************************************
    //******************* GPS CODE *******************
    //************************************************
    private void makeUseOfThisLocation(Location loc) {
        lat = loc.getLatitude();
        lon = loc.getLongitude();
        Log.e("Location","Lon = "+lon);
        Log.e("Location","Lat = "+lat);
    }
    //************************************************
    //******************* GPS CODE *******************
    //************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_city_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

