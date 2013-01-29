package com.kranti.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class GPSLocationListener implements LocationListener{

    @Override
    public void onLocationChanged(Location location) {
        location.getLatitude();
        location.getLongitude();
        String text = "My current location is: Latitude = " + location.getLatitude() + "Longitud = " + location.getLongitude();
        System.out.println(text);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onProviderEnabled(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onProviderDisabled(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
