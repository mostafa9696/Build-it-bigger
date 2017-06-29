package com.udacity.gradle.builditbigger;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * Created by Mostafa on 4/20/2017.
 */

public class MainActivityFragment extends Fragment {
    //AdView adView;
    Button JokeButton;
    ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main,container,false);
        JokeButton=(Button)view.findViewById(R.id.tell_joke_button);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar);
        JokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                showTask();
            }
        });
        return view;
    }
    public void StopprogressBar()
    {
        progressBar.setVisibility(View.GONE);
    }
    public void showTask()
    {
        new MyAsyncTask().execute(this);
    }
}
