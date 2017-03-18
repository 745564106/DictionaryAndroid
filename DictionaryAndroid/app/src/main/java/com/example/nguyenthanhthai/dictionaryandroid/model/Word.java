package com.example.nguyenthanhthai.dictionaryandroid.model;

import java.util.List;

/**
 * Created by NguyenThanhThai on 3/18/2017.
 */

public class Word {
    int wordId;

    public Word(int wordId, String wordText, String pronounce) {
        this.wordId = wordId;
        this.wordText = wordText;
        this.pronounce = pronounce;
    }

    String wordText;
    String pronounce;

    Language language;
    List<Mearning> mearnings;

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getWordText() {
        return wordText;
    }

    public void setWordText(String wordText) {
        this.wordText = wordText;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Mearning> getMearnings() {
        return mearnings;
    }

    public void setMearnings(List<Mearning> mearnings) {
        this.mearnings = mearnings;
    }
}
