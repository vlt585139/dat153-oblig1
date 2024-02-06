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

    Option correct;

    int correctIndex;

    List<String> options;

    Button btnOption1;

    Button btnOption2;

    Button btnOption3;

    ImageView imageView;

    TextView pointsText;

    TextView statusText;

    int points;

    int attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        this.points = 0;
        this.attempts = 0;
        this.pointsText = findViewById(R.id.pointsText);
        this.statusText = findViewById(R.id.statusTextView);

        pointsText.setText("Points: " + points + "/" + attempts);

        createQuiz();
    }

    private void onAnswer(int thisIndex) {
        // If we answered correct, increase points
        // Update status text
        if(correctIndex == thisIndex) {
            points++;
            statusText.setText("Correct ✅");
        } else {
            statusText.setText("Incorrect ❌");
        }
        // Always increase attempts
        attempts++;
        // And update points text
        float percentage = ((float) points / attempts) * 100;
        int roundedPercentage = Math.round(percentage);
        String text = String.format("Points: %d/%d (%d%%)", points, attempts, roundedPercentage);
        pointsText.setText(text);

        // Update the buttons etc. (basically refresh view)
        createQuiz();
    }

    public void createQuiz() {
        correct = Storage.getOptionList().getRandomOption();
        options = Storage.getOptionList().getThreeRandomAnswers(correct);

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption1.setText(options.get(0));

        btnOption2 = findViewById(R.id.btnOption2);
        btnOption2.setText(options.get(1));

        btnOption3 = findViewById(R.id.btnOption3);
        btnOption3.setText(options.get(2));

        imageView = findViewById(R.id.quizImage);
        imageView.setImageURI(correct.getImage());

        correctIndex = options.indexOf(correct.getMatchingName());

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
