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

    Button btnChooseImage;

    ImageView imagePreview;

    TextInputLayout inputLayout;
    TextInputEditText editText;

    Button btnAddImage;

    Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_option);

        btnChooseImage = findViewById(R.id.btnChooseImage);
        btnChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        imagePreview = findViewById(R.id.imagePreview);

        inputLayout = findViewById(R.id.inputLayout);
        editText = inputLayout.findViewById(R.id.inputName);

        btnAddImage = findViewById(R.id.btnAddImage);
        btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedImageUri == null || editText.getText() == null)
                    return;

                Option newEntry = new Option(selectedImageUri, editText.getText().toString().trim());
                Storage.getOptionList().add(newEntry);

                finish();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 124) {
                // Get the uri of the image from data
                selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    imagePreview.setImageURI(selectedImageUri);

                    int flags = Intent.FLAG_GRANT_READ_URI_PERMISSION;

                    getContentResolver().takePersistableUriPermission(selectedImageUri, flags);

                }
            }
        }
    }



    void imageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // dont care if its deprecated, the alternative is painful
        startActivityForResult(Intent.createChooser(i, "Select Picture"), 124);
    }
}