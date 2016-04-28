package it226.myapplicationit226androidapp;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

public class Logic extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("test","test");
            Toast.makeText(context, messageActivity.getMes()+"\n Lat: "+messageActivity.getLat()+"\n Long: "+ messageActivity.getLon(),
                    Toast.LENGTH_LONG).show();
    }

}
