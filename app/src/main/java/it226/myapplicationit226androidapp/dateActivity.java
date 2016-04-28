package it226.myapplicationit226androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class dateActivity extends AppCompatActivity {

    DatePicker datePicker;
    Logic logic;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        button = (Button) findViewById(R.id.button);

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp=new Intent("messageActivity");
                temp.putExtra("Activity","Alarm Clock");
                startActivity(temp);
            }
        });

    }
}
