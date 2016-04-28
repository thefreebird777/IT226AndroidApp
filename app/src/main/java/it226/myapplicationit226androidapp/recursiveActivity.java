package it226.myapplicationit226androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class recursiveActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    static Boolean recursiveBool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursive);

        button1 = (Button) findViewById(R.id.button8);
        button2 = (Button) findViewById(R.id.button9);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set alarm to be recursive
                recursiveBool=true;
                startActivity(new Intent("dateActivity"));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                recursiveBool=false;
                startActivity(new Intent("dateActivity"));
            }
        });

    }
    public static boolean getRecursive(){
        return recursiveBool;
    }
}
