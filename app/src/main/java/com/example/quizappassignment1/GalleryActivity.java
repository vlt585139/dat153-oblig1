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

    View relativeLayoutGallery;

    ListView listView;

    Button newImage;

    Button sort;

    GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        relativeLayoutGallery = findViewById(R.id.relativeLayoutGallery);

        Storage.getOptionList().sort();

        listView = relativeLayoutGallery.findViewById(R.id.galleryList);
        galleryAdapter = new GalleryAdapter(this, R.layout.list_row, Storage.getOptionList().getOptionList());
        listView.setAdapter(galleryAdapter);

        newImage = relativeLayoutGallery.findViewById(R.id.newImage);
        newImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryActivity.this, NewOptionActivity.class);

                // dont care its deprecated, the alternative is painful
                startActivityForResult(intent, 91);
            }
        });

        sort = relativeLayoutGallery.findViewById(R.id.sort);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Storage.getOptionList().changeSortType();
                Storage.getOptionList().sort();

                finish();
                startActivity(getIntent());
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        finish();
        startActivity(getIntent());
    }
}
