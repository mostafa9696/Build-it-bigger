package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;


import com.example.mostafa.displayjokes.DisplayJokes;
import com.example.mostafa.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Mostafa on 4/22/2017.
 */

public class MyAsyncTask extends AsyncTask<MainActivityFragment,Void,String> {
    MyApi Myapi=null;
    MyApi.Builder builder;
    Context MyContext;
    MainActivityFragment fragment;
    @Override
    protected String doInBackground(MainActivityFragment... params) {
        fragment=params[0];
        MyContext=fragment.getActivity();
        if(Myapi==null)
        {
            builder=new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")           // Run on AVD
                    
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            Myapi=builder.build();
        }
            try {
                return Myapi.sayHi("joke").execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
    }
    @Override
    protected void onPostExecute(String s) {
        fragment.StopprogressBar();
       Intent intent=new Intent(MyContext, DisplayJokes.class);
        intent.putExtra("joke",s);
        MyContext.startActivity(intent);
        //DisplayJokes();
    }

}
