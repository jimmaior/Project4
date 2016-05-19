package com.udcity.gradle.joke.test.joke;

import com.udcity.gradle.joke.Joker;

import org.junit.Test;

/**
 * Created by Jim M on 5/19/16.
 */
public class JokerTest {

    @Test
    public void testGetJoke() {
        String joke = "";
        assert joke.length() == 0;
        joke = Joker.getJoke();
        assert joke.length() > 0;
        System.out.println(joke);
    }
}
