package com.example.prashantkumar.data;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Rishabh on 5/10/2017.
 */
public class data extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
