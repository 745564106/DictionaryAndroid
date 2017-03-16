package com.example.nguyenthanhthai.actionbar;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by NguyenThanhThai on 3/16/2017.
 */

public class LocationFound extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_found);

        // get action bar
        ActionBar actionBar = getSupportActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.ic_location);
        actionBar.show();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_location);
    }
}
