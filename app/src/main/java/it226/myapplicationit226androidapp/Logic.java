package it226.myapplicationit226androidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class Logic extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent newIntent = new Intent(context, Displayer.class);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(newIntent);
    }
}
