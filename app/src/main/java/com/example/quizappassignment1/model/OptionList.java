package com.example.quizappassignment1.model;

import com.example.quizappassignment1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    public void add(Option newEntry) {
        optionList.add(newEntry);
    }

    public Option getRandomOption() {
        List<Option> copy = optionList;

        Collections.shuffle(copy);

        return copy.get(0);
    }

    public void sort() {
        optionList.sort((a, b) -> a.getMatchingName().compareTo(b.getMatchingName()));
    }

    public List<String> getThreeRandomAnswers(Option correct) {
        List<String> answers = new ArrayList<String>();
        List<Option> copy = optionList;

        answers.add(correct.getMatchingName());

        Collections.shuffle(copy);

        Option wrongOption1, wrongOption2;

        if(copy.get(0).equals(correct)) {
            wrongOption1 = copy.get(1);
            wrongOption2 = copy.get(2);
        }
        else {
            wrongOption1 = copy.get(0);
            if(copy.get(1).equals(correct)) {
                wrongOption2 = copy.get(2);
            }
            else {
                wrongOption2 = copy.get(1);
            }
        }

        answers.add(wrongOption1.getMatchingName());
        answers.add(wrongOption2.getMatchingName());

        Collections.shuffle(answers);

        return answers;
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
