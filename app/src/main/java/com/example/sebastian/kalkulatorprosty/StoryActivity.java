package com.example.sebastian.kalkulatorprosty;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DatabaseHelper database = new DatabaseHelper(this);
        String History = database.getData().toString();
        TextView textView = findViewById(R.id.ViewHistory);
        textView.setText(History);
    }

    public void clearHistory(View view) {
        DatabaseHelper database = new DatabaseHelper(this);
        database.cleanData();
        TextView textView = findViewById(R.id.ViewHistory);
        String History = database.getData().toString();
        textView.setText(History);
    }

}
