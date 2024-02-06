package com.example.quizappassignment1.model;

import android.net.Uri;

import java.util.Objects;

/**
 * Class to store Uri and the corresponding name
 */
public class Option {

    private Uri image;
    private String matchingName;

    /**
     * Constructor for Option class
     * @param image - Uri of the image
     * @param matchingName - the name assosiated with the image
     */
    public Option(Uri image, String matchingName) {
        this.image = image;
        this.matchingName = matchingName;
    }

    /**
     * Method to get the image
     * @return
     */
    public Uri getImage() {
        return image;
    }

    /**
     * Method to set the image
     * @param image - Uri for the image
     */
    public void setImage(Uri image) {
        this.image = image;
    }

    /**
     * Method to get the matching name
     * @return
     */
    public String getMatchingName() {
        return matchingName;
    }

    /**
     * Method to set the matching name
     * @param matchingName
     */
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
