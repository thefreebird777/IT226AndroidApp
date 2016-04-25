package it226.myapplicationit226androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class locationActivity extends AppCompatActivity {
    NumberPicker numberPicker;
    Button button;
    Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        numberPicker = (NumberPicker) findViewById(R.id.numberPicker3);
        button = (Button) findViewById(R.id.button7);

        String[] nums = new String[121];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.toString(i);

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(120);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDisplayedValues(nums);
        numberPicker.setValue(2);

        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logic.locationTime(numberPicker.getValue());
                startActivity(new Intent("cp3.tutorials.messageActivity"));
            }
        });

    }

}
