package it226.myapplicationit226androidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AppLocationService extends BroadcastReceiver{
    final double startLon=MainActivity.getLon();
    final double startLat=MainActivity.getLat();
    @Override
    public void onReceive(Context context, Intent intent) {
        if((startLat==messageActivity.getLat()) && (startLon==messageActivity.getLon())){
            Toast.makeText(context, messageActivity.getMes(),
                    Toast.LENGTH_LONG).show();
        }
    }
}
