package com.example.quizappassignment1.model;

import com.example.quizappassignment1.R;

import java.util.Arrays;
import java.util.List;

public class OptionList {

    private List<Option> optionList;

    public OptionList() {
        this.optionList = Arrays.asList(
                new Option(R.drawable.kamera, "Camera"),
                new Option(R.drawable.tre, "Tree"),
                new Option(R.drawable.natur, "Nature"),
                new Option(R.drawable.loanlink_logo, "Loanlink"));
    }

    public void add(Option newEntry) {
        optionList.add(newEntry);
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("List: { \n");
        for(Option o : optionList) {
            str.append(o.getImage()).append(" ").append(o.getMatchingName()).append("\n");
        }
        str.append("}");
        return str.toString();
    }
}
