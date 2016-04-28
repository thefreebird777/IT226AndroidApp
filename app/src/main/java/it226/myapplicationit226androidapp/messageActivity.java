package it226.myapplicationit226androidapp;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class messageActivity extends AppCompatActivity {
    static EditText editText;
    Button button;
    //Logic logic = new Logic();
    String receiverFlag;
    PendingIntent pending_intent;
    PendingIntent pending_intent2;
    AlarmManager alarm_manager;
    Context context;
    Boolean recursiveBool;
    static Double lat;
    static Double lon;
    GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button6);
        this.context=this;
        alarm_manager=(AlarmManager) getSystemService(ALARM_SERVICE);

        final Intent logic_intent = new Intent(this.context,Logic.class);
        final Intent location_intent = new Intent(this.context,Logic.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //SET RECEIVER FLAG TO AUTO GENERATE
                gps= new GPSTracker(messageActivity.this);

                if(gps.canGetLocation()){
                    lat= gps.getLat();
                    lon= gps.getLong();
                    //Toast.makeText(getApplicationContext(),"Your location is -\nLat: "+lat+"\nLong: "+lon,Toast.LENGTH_LONG).show();
                }
                else{
                    gps.showSettingsAlert();
                }
                //creates unique id per intent
                int id= (int)System.currentTimeMillis();
                Intent temp = getIntent();
                receiverFlag=temp.getStringExtra("Activity");
                pending_intent = PendingIntent.getBroadcast(messageActivity.this, id,logic_intent, PendingIntent.FLAG_UPDATE_CURRENT);
                pending_intent2 = PendingIntent.getBroadcast(messageActivity.this, id,location_intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if(receiverFlag.equals("Timer")){
                    int minuteMil=timerActivity.getMinute()*60*1000;
                    int hourMil=timerActivity.getHour()*60*1000*60;
                    alarm_manager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+hourMil+minuteMil,pending_intent);
                }
                else if(receiverFlag.equals("Location")){
                    alarm_manager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),1000*60*locationActivity.getNum(),pending_intent2);
                }
                else if(receiverFlag.equals("Alarm Clock")) {
                    recursiveBool = recursiveActivity.getRecursive();
                    if (recursiveBool) {
                        Calendar calendar = Calendar.getInstance();
                        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                        int mon = dateActivity.getMonth();
                        int day = dateActivity.getDay();
                        int currentMon = calendar.get(Calendar.MONTH);
                        if (currentDay + (currentMon * 30) > day + ((mon) * 30)) {
                            alarm_manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),30* 24 * 60 * 1000 * 60, pending_intent);
                        } else {
                            int currentHr = calendar.get(Calendar.HOUR_OF_DAY);
                            int currentMin = calendar.get(Calendar.MINUTE);
                            int minute = clockActivity.getMinute();
                            int hour = clockActivity.getHour();
                            if ((currentHr * 60) + currentMin >= (hour * 60) + minute) {
                                alarm_manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),30* 24 * 60 * 1000 * 60, pending_intent);
                            } else {
                                int minuteMil = minute * 60 * 1000;
                                int hourMil = hour * 60 * 1000 * 60;
                                int daysLeft = day + (mon * 30) - (currentDay + (currentMon * 30));
                                long dayMil = (long) (daysLeft) * 24 * 60 * 1000 * 60;
                                long delay = (long) (minuteMil + hourMil + dayMil);
                                alarm_manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+delay,30* 24 * 60 * 1000 * 60, pending_intent);
                            }
                        }
                    }
                    else {
                        Calendar calendar = Calendar.getInstance();
                        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                        int mon = dateActivity.getMonth();
                        int day = dateActivity.getDay();
                        int currentMon = calendar.get(Calendar.MONTH);
                        if (currentDay + (currentMon * 30) > day + ((mon) * 30)) {
                            alarm_manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pending_intent);
                        } else {
                            int currentHr = calendar.get(Calendar.HOUR_OF_DAY);
                            int currentMin = calendar.get(Calendar.MINUTE);
                            int minute = clockActivity.getMinute();
                            int hour = clockActivity.getHour();
                            if ((currentHr * 60) + currentMin >= (hour * 60) + minute) {
                                alarm_manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pending_intent);
                            } else {
                                int minuteMil = minute * 60 * 1000;
                                int hourMil = hour * 60 * 1000 * 60;
                                int daysLeft = day + (mon * 30) - (currentDay + (currentMon * 30));
                                long dayMil = (long) (daysLeft) * 24 * 60 * 1000 * 60;
                                long delay = (long) (minuteMil + hourMil + dayMil);
                                alarm_manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay, pending_intent);
                            }
                        }
                    }
                }
                Intent intent = new Intent(messageActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }


        });
    }
    public void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_popup_reminder);
        builder.setContentTitle(messageActivity.getMes());
        builder.setContentText("Lat: " + getLat()+"\n Long: "+getLon());
        Intent intent = new Intent(this, SecondClass.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(SecondClass.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0, builder.build());
    }
    public static String getMes(){
        return editText.getText().toString();
    }

    public static double getLat(){
        return lat;
    }
    public static double getLon(){
        return lon;
    }


}
