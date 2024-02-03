package com.example.quizappassignment1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizappassignment1.adapter.GalleryAdapter;

public class GalleryActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        listView = findViewById(R.id.galleryList);

        GalleryAdapter galleryAdapter = new GalleryAdapter(this, R.layout.list_row, MainActivity.optionList.getOptionList());

        listView.setAdapter(galleryAdapter);

        Log.d("Test", MainActivity.optionList.toString());
    }
}
