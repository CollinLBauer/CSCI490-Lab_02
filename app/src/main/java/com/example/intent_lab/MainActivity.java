package com.example.intent_lab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity{

    Button button;
    EditText userInputField;
    ConstraintLayout layout;
    private static final String TAG = "MainActivity";
    public static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"First activity started");

        // define intents
        Intent intentIn = getIntent();
        Intent intentOut = new Intent(this, SecondActivity.class);

        // instantiate views
        button = findViewById(R.id.button);
        userInputField = findViewById(R.id.user_input);
        layout = findViewById(R.id.activity_first);

        // define button listener
        button.setOnClickListener(listener -> {
            Log.i(TAG, "onClick reached"); //debug
            intentOut.putExtra("input", userInputField.getText().toString());
            startActivityForResult(intentOut, REQUEST_CODE);
        });

        // if a background is supplied, set the background
        /* Replaced with onActivityResult
        int imageID = intentIn.getIntExtra("image_id",0);
        if (imageID != 0) {
            layout.setBackground(ContextCompat.getDrawable(this, imageID));
        }
        */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.i(TAG,"onActivityRseult reached");

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            int imageID = data.getIntExtra("image_id", 0);
            layout.setBackground(ContextCompat.getDrawable(this, imageID));
        }
    }
}
