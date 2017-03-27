package com.example.nguyenthanhthai.dictionaryandroid.model;

import java.util.List;

/**
 * Created by NguyenThanhThai on 3/18/2017.
 */

public class Mearning {
    int exampleId;
    String mearningText;
    Word word;
    Language language;
    List<Example> examples;

    public Mearning(int exampleId, String mearningText, List<Example> examples) {
        this.exampleId = exampleId;
        this.mearningText = mearningText;
        this.word = word;
        this.language = language;
        this.examples = examples;
    }

    public List<Example> getExamples() {

        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

    public int getExampleId() {
        return exampleId;
    }

    public void setExampleId(int exampleId) {
        this.exampleId = exampleId;
    }

    public String getMearningText() {
        return mearningText;
    }

    public void setMearningText(String mearningText) {
        this.mearningText = mearningText;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Mearning(int exampleId, String mearningText) {

        this.exampleId = exampleId;
        this.mearningText = mearningText;
    }
    public Mearning() {}
}
