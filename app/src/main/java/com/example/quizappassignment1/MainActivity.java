package com.example.quizappassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.quizappassignment1.model.Option;
import com.example.quizappassignment1.model.OptionList;

// Import statements for Option and OptionList classes

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the "Open Gallery" button and set its click listener
        Button openGalleryButton = (Button) findViewById(R.id.openGallery);
        openGalleryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Log a message indicating the button click
                Log.d("BUTTONS", "Open Gallery");
                // Create an intent to start the GalleryActivity
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                // Start the GalleryActivity
                startActivity(intent);
            }
        });

        // Find the "Open Quiz" button and set its click listener
        Button openQuizButton = (Button) findViewById(R.id.openQuiz);
        openQuizButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Log a message indicating the button click
                Log.d("BUTTONS", "Open Quiz");
                // Create an intent to start the QuizActivity
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                // Start the QuizActivity
                startActivity(intent);
            }
        });
    }
}
