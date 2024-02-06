package com.example.quizappassignment1.model;

import android.net.Uri;

import java.util.Objects;

public class Option {

    private Uri image;
    private String matchingName;

    public Option(Uri image, String matchingName) {
        this.image = image;
        this.matchingName = matchingName;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public String getMatchingName() {
        return matchingName;
    }

    public void setMatchingName(String matchingName) {
        this.matchingName = matchingName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return image == option.image && Objects.equals(matchingName, option.matchingName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, matchingName);
    }

    @Override
    public String toString() {
        return "Option{" +
                "image=" + image +
                ", matchingName='" + matchingName + '\'' +
                '}';
    }


}
