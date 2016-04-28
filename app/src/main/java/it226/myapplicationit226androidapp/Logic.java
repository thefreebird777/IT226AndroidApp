package it226.myapplicationit226androidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Logic extends BroadcastReceiver {
    String str="";
    public void date(int day, int month){

    }

    public void time(int hour, int minute){

    }

    public void message(String message){
        this.str=message;
    }

    public void timer(int hours, int minutes){

    }

    public void locationTime(int minutes){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("test",messageActivity.getMes());
        //Log.e("ERROR: ", "RECEIVER FLAG NOT WORKING");
    }
}
