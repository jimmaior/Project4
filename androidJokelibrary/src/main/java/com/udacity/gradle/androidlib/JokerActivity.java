package com.udacity.gradle.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class JokerActivity extends AppCompatActivity {

    public static final String JOKER_KEY = "joker_key";
    private static final String TAG = JokerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);
    }
}
