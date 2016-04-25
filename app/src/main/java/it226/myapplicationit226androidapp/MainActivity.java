package it226.myapplicationit226androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    public void alarmOnClick(View v){
       button1 = (Button)findViewById(R.id.button1);
       button1.setOnClickListener(this);
    }

    public void timerOnClick(View v){
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }


    public void locationOnClick(View v){
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    private void button1Click(){
        startActivity(new Intent("cp3.tutorials.dateActivity"));
    }
    private void button2Click(){
        startActivity(new Intent("cp3.tutorials.timerActivity"));
    }
    private void button3Click(){
        startActivity(new Intent("cp3.tutorials.locationActivity"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
