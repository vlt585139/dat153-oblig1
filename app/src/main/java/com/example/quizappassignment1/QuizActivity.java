package com.example.quizappassignment1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizappassignment1.model.Option;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    Option correct;

    List<String> options;

    Button btnOption1;

    Button btnOption2;

    Button btnOption3;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        createQuiz();
    }

    public void createQuiz() {
        correct = MainActivity.optionList.getRandomOption();
        options = MainActivity.optionList.getThreeRandomAnswers(correct);

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption1.setText(options.get(0));

        btnOption2 = findViewById(R.id.btnOption2);
        btnOption2.setText(options.get(1));

        btnOption3 = findViewById(R.id.btnOption3);
        btnOption3.setText(options.get(2));

        imageView = findViewById(R.id.quizImage);
        imageView.setImageResource(correct.getImage());
    }
}
