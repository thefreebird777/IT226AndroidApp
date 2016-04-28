package it226.myapplicationit226androidapp;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class timeZoneActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    static String id;
    static TimeZone timezone = new TimeZone() {
        @Override
        public int getOffset(int era, int year, int month, int day, int dayOfWeek, int timeOfDayMillis) {
            return 0;
        }

        @Override
        public int getRawOffset() {
            return 0;
        }

        @Override
        public boolean inDaylightTime(Date time) {
            return false;
        }

        @Override
        public void setRawOffset(int offsetMillis) {

        }

        @Override
        public boolean useDaylightTime() {
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_zone);

        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById((R.id.button10));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                timezone.getAvailableIDs() );

        listView.setAdapter(arrayAdapter);

        listView.setSelection(93);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.getId();
                Intent temp=new Intent("messageActivity");
                temp.putExtra("Activity","Alarm Clock");
                startActivity(temp);
            }
        });

    }
    public static int timeDifference(){
        return  TimeZone.getTimeZone(id).getOffset(Calendar.getInstance().getTimeInMillis());
    }

}
