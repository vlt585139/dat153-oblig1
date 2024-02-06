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

    View includedLayout;

    ListView listView;

    Button newImage;

    ImageView selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Storage.getOptionList().sort();

        listView = findViewById(R.id.galleryList);
        GalleryAdapter galleryAdapter = new GalleryAdapter(this, R.layout.list_row, Storage.getOptionList().getOptionList());
        listView.setAdapter(galleryAdapter);

        includedLayout = findViewById(R.id.includedLayout);
        newImage = includedLayout.findViewById(R.id.newImage);
        selectedImage = includedLayout.findViewById(R.id.selectedImage);

        newImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryActivity.this, NewOptionActivity.class);
                startActivity(intent);
            }
        });

        Log.d("Test", Storage.getOptionList().toString());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
