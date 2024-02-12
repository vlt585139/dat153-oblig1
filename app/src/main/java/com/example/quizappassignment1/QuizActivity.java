package com.example.quizappassignment1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizappassignment1.model.Option;
import com.example.quizappassignment1.model.Storage;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    // Variables to store the correct option, its index, and the list of options
    Option correct;
    int correctIndex;
    List<String> options;

    // UI elements
    Button btnOption1;
    Button btnOption2;
    Button btnOption3;
    ImageView imageView;
    TextView pointsText;
    TextView statusText;

    // Variables to keep track of points and attempts
    int points;
    int attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize points and attempts
        this.points = 0;
        this.attempts = 0;

        // Find UI elements
        this.pointsText = findViewById(R.id.pointsText);
        this.statusText = findViewById(R.id.statusTextView);

        // Display initial points and attempts
        pointsText.setText("Points: " + points + "/" + attempts);

        // Create a new quiz question
        createQuiz();
    }

    // Method to handle user answers
    private void onAnswer(int thisIndex) {
        // Check if the answer is correct and update points and status text
        if(correctIndex == thisIndex) {
            points++;
            statusText.setText("Correct ✅");
        } else {
            statusText.setText("Incorrect ❌");
        }

        // Always increase attempts
        attempts++;

        // Update points text to show points and percentage
        float percentage = ((float) points / attempts) * 100;
        int roundedPercentage = Math.round(percentage);
        String text = String.format("Points: %d/%d (%d%%)", points, attempts, roundedPercentage);
        pointsText.setText(text);

        // Generate a new quiz question
        createQuiz();
    }

    // Method to create a new quiz question
    public void createQuiz() {
        // Select a correct answer and three random incorrect answers
        correct = Storage.getOptionList().getRandomOption();
        options = Storage.getOptionList().getThreeRandomAnswers(correct);

        // Display options and image for the quiz question
        btnOption1 = findViewById(R.id.btnOption1);
        btnOption1.setText(options.get(0));

        btnOption2 = findViewById(R.id.btnOption2);
        btnOption2.setText(options.get(1));

        btnOption3 = findViewById(R.id.btnOption3);
        btnOption3.setText(options.get(2));

        imageView = findViewById(R.id.quizImage);
        imageView.setImageURI(correct.getImage());

        // Set click listeners for buttons to handle user answers
        btnOption1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onAnswer(0);
            }
        });
        btnOption2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onAnswer(1);
            }
        });
        btnOption3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onAnswer(2);
            }
        });
    }
}
