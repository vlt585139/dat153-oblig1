package com.example.quizappassignment1.model;

public class Option {

    private int image;
    private String matchingName;

    public Option(int image, String matchingName) {
        this.image = image;
        this.matchingName = matchingName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMatchingName() {
        return matchingName;
    }

    public void setMatchingName(String matchingName) {
        this.matchingName = matchingName;
    }

    @Override
    public String toString() {
        return "Option{" +
                "image=" + image +
                ", matchingName='" + matchingName + '\'' +
                '}';
    }
}
