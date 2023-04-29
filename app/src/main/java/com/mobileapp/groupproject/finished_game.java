package com.mobileapp.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class finished_game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_game);

        // Get the intent that started this activity
        Intent intent = getIntent();

        // Get the values from the intent as integers
        int stage = intent.getIntExtra("stage", 0);
        int stars = intent.getIntExtra("stars", 0);



    }
}