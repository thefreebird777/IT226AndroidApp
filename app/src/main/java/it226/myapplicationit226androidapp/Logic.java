package it226.myapplicationit226androidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Logic extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("test",messageActivity.getMes());
        //Log.e("ERROR: ", "RECEIVER FLAG NOT WORKING");
    }
}
