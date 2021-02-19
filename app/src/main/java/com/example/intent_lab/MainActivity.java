package com.example.intent_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    String userInput;
    Button button;
    EditText userInputField;
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        userInputField = findViewById(R.id.user_input);
        userInput = "";

        Intent intent = new Intent(this, SecondActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick reached"); //debug
                userInput = userInputField.getText().toString();
                intent.putExtra("input",userInput);
                startActivity(intent);
            }
        });
    }

}