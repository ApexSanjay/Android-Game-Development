package com.mobileapp.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class circle_game extends AppCompatActivity {
    private ImageView circleImage;
    private TextView scoreText;
    private int score = 0;
    private CountDownTimer countDownTimer;
    private TextView countdownTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_game);

        // Get references to the game elements
        circleImage = findViewById(R.id.circle_image);
        scoreText = findViewById(R.id.score_text);

        // Get the TextView with the ID "countdown_timer"
        countdownTextView = findViewById(R.id.time_text);

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
                Intent intent = new Intent(circle_game.this, finished_game.class);
                // Add data to the intent as key-value pairs
                intent.putExtra("stage", 1);
                intent.putExtra("stars",stars);

                // Start the activity with the intent
                startActivity(intent);
            }
        };

        // Start the countdown timer
        countDownTimer.start();

        // Set up the click listener for the circle
        circleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment the score and update the score text
                score++;
                scoreText.setText("Score: " + score);

                // Move the circle to a new random position
                moveCircleRandomly();
            }
        });

        // Start the game loop
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                moveCircleRandomly();
                handler.postDelayed(this, 1000);
            }
        }, 1000);

        //Home Button
        ImageView home_button = findViewById(R.id.s_circle_home);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(circle_game.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Replay button
        ImageView replay_button = findViewById(R.id.s_circle_replay);
        replay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(circle_game.this, fruit_game.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void moveCircleRandomly() {
        // Generate random x and y coordinates for the circle
        int containerWidth = ((ViewGroup) circleImage.getParent()).getWidth();
        int containerHeight = ((ViewGroup) circleImage.getParent()).getHeight();
        int circleWidth = circleImage.getWidth();
        int circleHeight = circleImage.getHeight();
        int maxX = containerWidth - circleWidth;
        int maxY = containerHeight - circleHeight;
        int randomX = new Random().nextInt(maxX);
        int randomY = new Random().nextInt(maxY);

        // Animate the circle to the new position
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(circleImage, "x", randomX);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(circleImage, "y", randomY);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorX, animatorY);
        animatorSet.setDuration(300);
        animatorSet.start();
    }


}