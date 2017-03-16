package com.example.nguyenthanhthai.actionbar.model;

/**
 * Created by NguyenThanhThai on 3/16/2017.
 */

public class SpinnerNavItem {

    private String title;
    private int icon;

    public SpinnerNavItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }

    public String getTitle(){
        return this.title;
    }

    public int getIcon(){
        return this.icon;
    }
}
