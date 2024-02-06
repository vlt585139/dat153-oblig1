package com.example.quizappassignment1.model;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;

import com.example.quizappassignment1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Storage extends Application {

    private static OptionList optionList;

    @Override
    public void onCreate() {
        super.onCreate();
        Storage.optionList = new OptionList();
        convertImageToUriAndAddToList(R.drawable.kamera, "Camera");
        convertImageToUriAndAddToList(R.drawable.natur, "Nature");
        convertImageToUriAndAddToList(R.drawable.loanlink_logo, "Loanlink");
        convertImageToUriAndAddToList(R.drawable.tre, "Tree");
    }

    public static OptionList getOptionList() {
        return optionList;
    }

    public static void setOptionList(OptionList optionList) {
        Storage.optionList = optionList;
    }

    public void convertImageToUriAndAddToList(int imageResourceId, String name) {
        Uri imageUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE) // "android.resource"
                .authority(getResources().getResourcePackageName(imageResourceId))
                .appendPath(getResources().getResourceTypeName(imageResourceId))
                .appendPath(getResources().getResourceEntryName(imageResourceId))
                .build();
        optionList.add(new Option(imageUri, name));
    }
}
