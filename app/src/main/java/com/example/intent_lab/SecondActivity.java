package com.example.intent_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String displayText;
    TextView displayView;
    String TAG = "SecondActivity";
    ImageButton firstImage;
    ImageButton secondImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intentIn = getIntent();
        Intent intentOut = new Intent(this, MainActivity.class);


        Log.i(TAG, "Second activity started");

        displayView = findViewById(R.id.display_user_input);
        displayText = String.format("Hello, %s! Please choose a background.",intentIn.getStringExtra("input"));
        displayView.setText(displayText);

        firstImage = findViewById(R.id.image_first);
        secondImage = findViewById(R.id.image_second);
        firstImage.setOnClickListener(firstListener -> {
            Log.i(TAG, "First image selected"); //debug
            intentOut.putExtra("image_id",R.drawable.supermoon);
            startActivity(intentOut);
        });
        secondImage.setOnClickListener(secondListener -> {
            Log.i(TAG, "Second image selected"); //debug
            intentOut.putExtra("image_id",R.drawable.waterfall);
            startActivity(intentOut);
        });


    }

}