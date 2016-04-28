package it226.myapplicationit226androidapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class messageActivity extends AppCompatActivity {
    static EditText editText;
    Button button;
    Logic logic = new Logic();
    String receiverFlag;
    PendingIntent pending_intent;
    AlarmManager alarm_manager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button6);
        this.context=this;
        alarm_manager=(AlarmManager) getSystemService(ALARM_SERVICE);

        final Intent logic_intent = new Intent(this.context,Logic.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SET RECEIVER FLAG TO AUTO GENERATE

                //creates unique id per intent
                int id= (int)System.currentTimeMillis();
                Intent temp = getIntent();
                receiverFlag=temp.getStringExtra("Activity");
                pending_intent = PendingIntent.getBroadcast(messageActivity.this, id,logic_intent, PendingIntent.FLAG_UPDATE_CURRENT);
                //receiverFlag=editText.getText().toString();
                if(receiverFlag.equals("Timer")){
                    int minuteMil=timerActivity.getMinute()*60*1000;
                    int hourMil=timerActivity.getHour()*60*1000*60;
                    alarm_manager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+hourMil+minuteMil,pending_intent);
                }
                else if(receiverFlag.equals("Location")){
                    alarm_manager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pending_intent);
                }
                else if(receiverFlag.equals("Alarm Clock")){
                    alarm_manager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pending_intent);
                }

                logic.message(editText.getText().toString());
                Intent intent = new Intent(messageActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }


        });
    }
    public static String getMes(){
        return editText.getText().toString();
    }

}
