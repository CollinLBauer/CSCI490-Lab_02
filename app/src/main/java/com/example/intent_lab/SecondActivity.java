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
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.i(TAG, "Second activity started");

        // define intents
        Intent intentIn = getIntent();


        // instantiate views
        displayView = findViewById(R.id.display_user_input);
        displayText = String.format("Hello, %s! Please choose a background.",intentIn.getStringExtra("input"));
        displayView.setText(displayText);
        firstImage = findViewById(R.id.image_first);
        secondImage = findViewById(R.id.image_second);

        // set click listeners
        firstImage.setOnClickListener(firstListener -> {
            Log.i(TAG, "First image selected"); //debug
            chooseBackground(R.drawable.supermoon);
        });
        secondImage.setOnClickListener(secondListener -> {
            Log.i(TAG, "Second image selected"); //debug
            chooseBackground(R.drawable.waterfall);
        });
    }

    // sets background and returns to main activity
    private void chooseBackground(int backgroundID) {
        Intent intentOut = new Intent(this, MainActivity.class);
        intentOut.putExtra("image_id", backgroundID);
        setResult(RESULT_OK, intentOut);
        finish();
    }

}
