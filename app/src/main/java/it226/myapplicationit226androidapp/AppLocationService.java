package it226.myapplicationit226androidapp;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

public class AppLocationService extends Service implements LocationListener {

    LocationManager locationManager;
    Location location;


    private static final long MIN_DISTANCE_FOR_UPDATE = 1;
    private static final long MIN_TIME_FOR_UPDATE = 1000;

    public AppLocationService(Context context) {
        locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);

    }

    public Location getLocation(String provider) {
        if (locationManager.isProviderEnabled(provider)) {
            locationManager.requestLocationUpdates(provider,
                    MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
            if (locationManager != null) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
//                    ActivityCompat.requestPermissions(,INITIAL_PERMS,);
//                    ActivityCompat.requestPermissions(,CAMERA_PERMS,);
//                    ActivityCompat.requestPermissions(,CONTACTS_PERMS,);
//                    ActivityCompat.requestPermissions(,LOCATION_PERMS,);

                    return null;
                }
                location = locationManager.getLastKnownLocation(provider);
                return location;
            }
        }
        return null;


    }

    private static final String[] INITIAL_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_CONTACTS
    };
    private static final String[] CAMERA_PERMS={
            Manifest.permission.CAMERA
    };
    private static final String[] CONTACTS_PERMS={
            Manifest.permission.READ_CONTACTS
    };
    private static final String[] LOCATION_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION
    };


    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(
                getApplicationContext(),
                "Mobile Location (GPS): \nLat",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

}
