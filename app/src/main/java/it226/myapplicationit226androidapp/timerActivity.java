package it226.myapplicationit226androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;


public class timerActivity extends AppCompatActivity {
    static NumberPicker numberPicker;
    static NumberPicker numberPicker2;
    Button button;
    Logic logic = new Logic();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        numberPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);
        button = (Button) findViewById(R.id.button5);

        String[] nums = new String[61];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.toString(i);

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(24);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDisplayedValues(nums);
        numberPicker.setValue(0);

        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(59);
        numberPicker2.setWrapSelectorWheel(false);
        numberPicker2.setDisplayedValues(nums);
        numberPicker2.setValue(0);

        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numberPicker2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logic.timer(numberPicker.getValue(),numberPicker2.getValue());
                startActivity(new Intent("cp3.tutorials.messageActivity"));
            }
        });
    }
    public static int getMinute(){
        return numberPicker2.getValue();
    }
    public static int getHour(){
        return numberPicker.getValue();
    }
}

