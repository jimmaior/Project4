package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.util.Pair;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.androidlib.JokerActivity;
import com.udcity.gradle.joke.Joker;


public class MainActivity extends AppCompatActivity
    implements OnFetchJokeTaskComplete {

    private static final String TAG = MainActivity.class.getSimpleName();
//    private InterstitialAd mInterstitialAd;
    private String mJoke;
    private Button mButton;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {

        } else {

        }

        // progressbar
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setIndeterminate(true);
        mProgressBar.setVisibility(View.GONE);

        // button
        mButton = (Button) findViewById(R.id.btn_tell_joke);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                tellJoke();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke () {
        new JokeEndpointAsyncTask(this).execute();
    }

    public void onFetchJokeComplete(String joke){
        if (joke.length() > 0) {
            mJoke = joke;
            showJokeToUser();
        } else {
            Toast.makeText(this, "derp", Toast.LENGTH_LONG).show();
        }
        mProgressBar.setVisibility(View.GONE);
    }

    private void showJokeToUser() {
//        if (mInterstitialAd.isLoaded()) {
//            mInterstitialAd.show();
//        } else {
            Intent intent = new Intent(this, JokerActivity.class);
            intent.putExtra(JokerActivity.JOKER_KEY, mJoke);
            startActivity(intent);
//        }
    }

//    private void requestNewInterstitial() {
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build();
//    mInterstitialAd.loadAd(adRequest);
//    }

}
