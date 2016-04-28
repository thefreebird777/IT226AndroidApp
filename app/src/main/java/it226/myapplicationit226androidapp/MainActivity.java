package it226.myapplicationit226androidapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    PendingIntent pending_intent;
    AlarmManager alarm_manager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        this.context=this;
//        alarm_manager=(AlarmManager) getSystemService(ALARM_SERVICE);
//        final Intent logic_intent = new Intent(this.context,Logic.class);
//        pending_intent= PendingIntent.getBroadcast(MainActivity.this,0,logic_intent,PendingIntent.FLAG_UPDATE_CURRENT);
//        alarm_manager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pending_intent);
//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void button1Click() {startActivity(new Intent("recursiveActivity"));}

    private void button2Click() {
        startActivity(new Intent("timerActivity"));
    }

    private void button3Click() {startActivity(new Intent("AndroidLocationActivity"));}


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                button1Click();
                break;
            case R.id.button2:
                button2Click();
                break;
            case R.id.button3:
                button3Click();
                break;
        }
    }
}

