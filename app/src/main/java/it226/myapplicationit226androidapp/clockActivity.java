package it226.myapplicationit226androidapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Date;
import java.util.TimeZone;

public class clockActivity extends AppCompatActivity {
    static TimePicker timePicker;
    Logic logic;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);


        timePicker = (TimePicker) findViewById(R.id.timePicker);
        button = (Button) findViewById(R.id.button4);

        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent("time_zoneActivity"));
            }
        });
    }
    @TargetApi(Build.VERSION_CODES.M)
    public static int getMinute(){
        return timePicker.getMinute();
    }
    @TargetApi(Build.VERSION_CODES.M)
    public static int getHour(){
        return timePicker.getHour();
    }
}
