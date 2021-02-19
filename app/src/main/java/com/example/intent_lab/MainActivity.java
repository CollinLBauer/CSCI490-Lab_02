package com.example.intent_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    Button button;
    EditText userInputField;
    String TAG = "MainActivity";
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        userInputField = findViewById(R.id.user_input);
        layout = findViewById(R.id.activity_first);

        // define intents
        Intent intentOut = new Intent(this, SecondActivity.class);
        Intent intentIn = getIntent();

        // define button listener
        button.setOnClickListener(listener -> {
            Log.i(TAG, "onClick reached"); //debug
            intentOut.putExtra("input",userInputField.getText().toString());
            startActivity(intentOut);
        });

        // if a background is supplied, set the background
        int imageID = intentIn.getIntExtra("image_id",0);
        if (imageID != 0) {
            layout.setBackground(ContextCompat.getDrawable(this,imageID));
        }

    }

}