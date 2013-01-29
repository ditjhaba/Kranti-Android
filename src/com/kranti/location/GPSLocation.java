package com.kranti.location;


import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class GPSLocation {

    LocationManager locManager;
    String provider;

    public GPSLocation(Context context) {
        this.locManager =  (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locListener = new GPSLocationListener();
        Criteria criteria = new Criteria();
        provider = locManager.getBestProvider(criteria, false);
        locManager.requestLocationUpdates(provider, 400, 1, locListener);
    }

    public Location getLocation(){
        return locManager.getLastKnownLocation(provider);
    }
}
