package com.example.quizappassignment1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.quizappassignment1.model.Option;
import com.example.quizappassignment1.model.Storage;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NewOptionActivity extends AppCompatActivity {

    // Declare UI elements
    Button btnChooseImage;
    ImageView imagePreview;
    TextInputLayout inputLayout;
    TextInputEditText editText;
    Button btnAddImage;

    // URI for the selected image
    Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_option);

        // Find UI elements
        btnChooseImage = findViewById(R.id.btnChooseImage);
        imagePreview = findViewById(R.id.imagePreview);
        inputLayout = findViewById(R.id.inputLayout);
        editText = inputLayout.findViewById(R.id.inputName);
        btnAddImage = findViewById(R.id.btnAddImage);

        // Set click listener for "Choose Image" button
        btnChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method to open image chooser
                imageChooser();
            }
        });

        // Set click listener for "Add Image" button
        btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if image URI and text are not null
                if (selectedImageUri == null || editText.getText() == null)
                    return;

                // Create a new Option object with selected image URI and text
                Option newEntry = new Option(selectedImageUri, editText.getText().toString().trim());

                // Add the new entry to the list of options
                Storage.getOptionList().add(newEntry);

                // Finish the activity
                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check if result is OK and request code matches image chooser
        if (resultCode == RESULT_OK) {
            if (requestCode == 124) {
                // Get the URI of the selected image from data
                selectedImageUri = data.getData();
                
                // If URI is not null, set it to the image preview
                if (selectedImageUri != null) {
                    imagePreview.setImageURI(selectedImageUri);

                    // Grant read URI permission to ensure access to the image
                    int flags = Intent.FLAG_GRANT_READ_URI_PERMISSION;
                    getContentResolver().takePersistableUriPermission(selectedImageUri, flags);
                }
            }
        }
    }

    // Method to open image chooser
    void imageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // Start image chooser activity with request code
        startActivityForResult(Intent.createChooser(i, "Select Picture"), 124);
    }
}
