package com.example.mostafa.displayjokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokes extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);
        textView=(TextView)findViewById(R.id.joke);
        Intent intent=getIntent();
        String Joke=intent.getStringExtra("joke");
        textView.setText(Joke);
    }
}
