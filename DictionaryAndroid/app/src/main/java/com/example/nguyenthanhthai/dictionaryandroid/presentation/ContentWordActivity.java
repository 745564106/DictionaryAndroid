package com.example.nguyenthanhthai.dictionaryandroid.presentation;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyenthanhthai.dictionaryandroid.R;
import com.example.nguyenthanhthai.dictionaryandroid.adapter.ContentWordAdapter;
import com.example.nguyenthanhthai.dictionaryandroid.model.Word;

/**
 * Created by NguyenThanhThai on 3/27/2017.
 */

public class ContentWordActivity extends AppCompatActivity {
    ActionBar actionBar;
    private RecyclerView recyclerView;
    Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_word);

        getActionMyBar();
        addControls();
    }

    TextView wordText,wordPronounce;
    ImageView imageFavorite;
    private void addControls() {
        wordText= (TextView) findViewById(R.id.wordText);
        wordPronounce= (TextView) findViewById(R.id.wordPronounce);
        imageFavorite= (ImageView) findViewById(R.id.imageFavorite);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_search:
                // search action
                new SearchWordActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getActionMyBar() {
        // get the action bar
        actionBar = getSupportActionBar();

        actionBar.setHomeButtonEnabled(false);
        // Enabling Back navigation on Action Bar icon
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.show();


       handleIntent(getIntent());
    }

    //
    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    /**
     * Handling intent data
     */
    private void handleIntent(Intent intent) {
        word=new Word();
        word.setWordId(1);
        word.setWordText("accent");
        word.setPronounce("accent");

       intent.getIntExtra("WordId",0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Heeeee", Toast.LENGTH_SHORT).show();
       // wordText.setText(word.getWordText());

        ContentWordAdapter adapter = new ContentWordAdapter(word);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerMearning);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }
}
