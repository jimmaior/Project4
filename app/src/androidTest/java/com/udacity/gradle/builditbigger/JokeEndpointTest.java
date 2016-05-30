package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jim M on 5/31/16.
 */


/**
 * Created by jimm on 5/31/16.
 */
@RunWith(AndroidJUnit4.class)
public class JokeEndpointTest extends AndroidTestCase {

    CountDownLatch mSignal;
    String mJoke;

    @Test
    public void testJoke() {
        try {
            mSignal = new CountDownLatch(1);
            new JokeEndpointAsyncTask(new OnFetchJokeTaskComplete() {
                @Override
                public void onFetchJokeComplete(String joke) {
                    mJoke = joke;
                    mSignal.countDown();
                }
            }).execute();
            mSignal.await(30, TimeUnit.SECONDS);
            assertNotNull("Joke is null", mJoke);
            assertFalse("Joke is empty", mJoke.isEmpty());
        }
        catch (Exception e) {
            fail();
        }
    }
}