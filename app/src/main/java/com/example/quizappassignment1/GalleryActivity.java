package com.example.quizappassignment1;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizappassignment1.adapter.GalleryAdapter;

public class GalleryActivity extends AppCompatActivity {

    View includedLayout;

    ListView listView;

    Button newImage;

    ImageView selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        MainActivity.optionList.sort();

        listView = findViewById(R.id.galleryList);
        GalleryAdapter galleryAdapter = new GalleryAdapter(this, R.layout.list_row, MainActivity.optionList.getOptionList());
        listView.setAdapter(galleryAdapter);

        includedLayout = findViewById(R.id.includedLayout);
        newImage = includedLayout.findViewById(R.id.newImage);
        selectedImage = includedLayout.findViewById(R.id.selectedImage);

        newImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        Log.d("Test", MainActivity.optionList.toString());
    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), 124);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 124) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    selectedImage.setImageURI(selectedImageUri);
                }
            }
        }
    }
}
