package com.mobileapp.groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Locale;
import java.util.Random;

public class fruit_game extends AppCompatActivity {
    // Define a handler to schedule the position updates
    Handler handler = new Handler();

    // Define a runnable to update the positions of the image views
    private CountDownTimer countDownTimer;

    int score = 0;

    private TextView countdownTextView;
    Runnable updatePositions = new Runnable() {
        @Override
        public void run() {
            /* X:200-800 Y:200-1200 */
            //Set the X and Y coordinates for the fruits
            Random rand = new Random();
            int x1 = rand.nextInt(600) + 200;
            int y1 = rand.nextInt(1200)+200;

            int x2 = rand.nextInt(900) + 400;
            int y2 = rand.nextInt(1000)+200;

            int x3 = rand.nextInt(900) + 300;
            int y3 = rand.nextInt(800)+200;

            int x4 = rand.nextInt(500) + 200;
            int y4 = rand.nextInt(1000)+200;

            int x5 = rand.nextInt(800) + 100;
            int y5 = rand.nextInt(800)+500;


            ImageView placeholder1 = findViewById(R.id.s_object1);
            ImageView placeholder2 = findViewById(R.id.s_object2);
            ImageView placeholder3 = findViewById(R.id.s_object3);
            ImageView placeholder4 = findViewById(R.id.s_object4);
            ImageView placeholder5 = findViewById(R.id.s_object5);

            placeholder1.setX(x1);
            placeholder1.setY(y1);

            placeholder2.setX(x2);
            placeholder2.setY(y2);

            placeholder3.setX(x3);
            placeholder3.setY(y3);

            placeholder4.setX(x4);
            placeholder4.setY(y4);

            placeholder5.setX(x5);
            placeholder5.setY(y5);

            // Schedule the next update after a delay of 2 seconds
            handler.postDelayed(this, 2000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_game);

        TextView scoreTextView = findViewById(R.id.scoreTextView);

        // Get the TextView with the ID "countdown_timer"
        countdownTextView = findViewById(R.id.countdown_timer);

        // Set the countdown time in milliseconds
        long countdownTime = 30000; // 30 seconds

        // Create a new CountDownTimer object
        countDownTimer = new CountDownTimer(countdownTime, 1000) {

            // This method will be called every second with the remaining time
            @Override
            public void onTick(long millisUntilFinished) {
                // Calculate the remaining time in seconds
                long secondsRemaining = millisUntilFinished / 1000;

                // Update the TextView with the remaining time
                countdownTextView.setText("Seconds: " + secondsRemaining);
            }

            @Override
            public void onFinish() {
                // Perform an action when the countdown is finished
                countdownTextView.setText("Countdown finished!");

                //Convert the score to starts
                int stars=0;
                if(score>=20){
                    stars=3;
                } else if (score>=10) {
                    stars=2;
                } else if (score>=5) {
                    stars=1;
                }else{
                    stars=0;
                }

                //Send the value to the finished_game page
                // Create an intent to send data to another component
                Intent intent = new Intent(fruit_game.this, finished_game.class);
                // Add data to the intent as key-value pairs
                intent.putExtra("stage", 1);
                intent.putExtra("stars",stars);

                // Start the activity with the intent
                startActivity(intent);
            }
        };

        // Start the countdown timer
        countDownTimer.start();

        //Code to get the placeholder for the fruits
        ImageView placeholder1 = findViewById(R.id.s_object1);
        ImageView placeholder2 = findViewById(R.id.s_object2);
        ImageView placeholder3 = findViewById(R.id.s_object3);
        ImageView placeholder4 = findViewById(R.id.s_object4);
        ImageView placeholder5 = findViewById(R.id.s_object5);

        //Code to get the fruits
        Drawable fruit1 = ContextCompat.getDrawable(getBaseContext(),R.drawable.fruit1);
        Drawable fruit2 = ContextCompat.getDrawable(getBaseContext(),R.drawable.fruit2);
        Drawable fruit3 = ContextCompat.getDrawable(getBaseContext(),R.drawable.fruit3);
        Drawable fruit4 = ContextCompat.getDrawable(getBaseContext(),R.drawable.fruit4);
        Drawable fruit5 = ContextCompat.getDrawable(getBaseContext(),R.drawable.bomb);

        //Set the fruits in the placeholders
        placeholder1.setImageDrawable(fruit1);
        placeholder2.setImageDrawable(fruit2);
        placeholder3.setImageDrawable(fruit3);
        placeholder4.setImageDrawable(fruit4);
        placeholder5.setImageDrawable(fruit5);

        // Set the listener for the image views
        placeholder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000);
                v.startAnimation(alphaAnimation);

                // Increment the score by 1
                score++;
                // Update the score TextView
                scoreTextView.setText("Score: " + score);
            }
        });

        placeholder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000);
                v.startAnimation(alphaAnimation);

                // Increment the score by 1
                score++;
                // Update the score TextView
                scoreTextView.setText("Score: " + score);
            }
        });

        placeholder3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000);
                v.startAnimation(alphaAnimation);

                // Increment the score by 1
                score++;
                // Update the score TextView
                scoreTextView.setText("Score: " + score);
            }
        });

        placeholder4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000);
                v.startAnimation(alphaAnimation);
                // Increment the score by 1
                score++;
                // Update the score TextView
                scoreTextView.setText("Score: " + score);
            }
        });

        placeholder5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000);
                v.startAnimation(alphaAnimation);
                // Increment the score by 1
                score=0;
                // Update the score TextView
                scoreTextView.setText("Score: " + score);
            }
        });

        //Home Button
        ImageView home_button = findViewById(R.id.s_home_button);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fruit_game.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Replay button
        ImageView replay_button = findViewById(R.id.s_replay_button);
        replay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fruit_game.this, fruit_game.class);
                startActivity(intent);
                finish();
            }
        });


        // Schedule the position updates
        handler.postDelayed(updatePositions, 2000);
    }
}