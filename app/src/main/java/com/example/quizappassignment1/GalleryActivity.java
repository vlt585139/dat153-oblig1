package com.example.quizappassignment1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizappassignment1.adapter.GalleryAdapter;
import com.example.quizappassignment1.model.Storage;

public class GalleryActivity extends AppCompatActivity {

    // Declare UI elements
    View relativeLayoutGallery;
    ListView listView;
    Button newImage;
    Button sort;
    GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // Find the layout container for the gallery
        relativeLayoutGallery = findViewById(R.id.relativeLayoutGallery);

        // Sort the list of options
        Storage.getOptionList().sort();

        // Find the ListView for displaying gallery items
        listView = relativeLayoutGallery.findViewById(R.id.galleryList);

        // Create a new GalleryAdapter to populate the ListView
        galleryAdapter = new GalleryAdapter(this, R.layout.list_row, Storage.getOptionList().getOptionList());
        listView.setAdapter(galleryAdapter);

        // Find the "New Image" button and set its click listener
        newImage = relativeLayoutGallery.findViewById(R.id.newImage);
        newImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the NewOptionActivity
                Intent intent = new Intent(GalleryActivity.this, NewOptionActivity.class);

                // Start the NewOptionActivity, expect a result back
                startActivityForResult(intent, 91);
            }
        });

        // Find the "Sort" button and set its click listener
        sort = relativeLayoutGallery.findViewById(R.id.sort);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change the sort type of the option list
                Storage.getOptionList().changeSortType();

                // Sort the option list
                Storage.getOptionList().sort();

                // Finish the current activity and restart it to refresh the gallery
                finish();
                startActivity(getIntent());
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Finish the current activity and restart it to refresh the gallery
        finish();
        startActivity(getIntent());
    }
}
