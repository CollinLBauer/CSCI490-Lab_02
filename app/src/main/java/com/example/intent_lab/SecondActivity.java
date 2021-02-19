package com.example.intent_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String displayText;
    TextView displayView;
    String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        displayView = findViewById(R.id.display_user_input);
        Log.i(TAG, "Second activity started");
        Intent intent = getIntent();
        displayText = intent.getStringExtra("input");
        displayView.setText(displayText);
    }

}