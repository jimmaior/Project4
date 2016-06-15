package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.jokeendpoint.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Jim M on 5/27/16.
 */
//public class JokeEndpointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
public class JokeEndpointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private static final String TAG = JokeEndpointAsyncTask.class.getSimpleName();

  //  private MainActivity mCallerActivity;
    private  OnFetchJokeTaskComplete mFetchJokeListener;


    public JokeEndpointAsyncTask(OnFetchJokeTaskComplete listener) {
        mFetchJokeListener = listener;
    }

    @Override
    protected void onPreExecute() {
        Log.d(TAG,"onPreExecute");
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Log.d(TAG, "onProgressUpdate");
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        Log.d(TAG, "doInBackground");
        if (myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    //.setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setRootUrl("http://192.168.1.14:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
//            // end options for devappserver

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1328.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        try {
            return myApiService.tellAJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG, "onPostExecute");
       //mCallerActivity.showJoke(result);
        mFetchJokeListener.onFetchJokeComplete(result);
    }
}
