package it226.myapplicationit226androidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class messageActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button6);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logic.message(editText.getText().toString());
            }
        });
    }
}
