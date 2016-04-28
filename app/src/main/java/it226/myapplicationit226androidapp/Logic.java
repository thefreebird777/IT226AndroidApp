package it226.myapplicationit226androidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Logic extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

            Toast.makeText(context, messageActivity.getMes(),
                    Toast.LENGTH_LONG).show();
    }
}
