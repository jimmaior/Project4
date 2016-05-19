package com.udcity.gradle.joke;

import java.util.Random;

public class Joker {

    static String[] mJokes = {
            "As President Roosevelt said: 'We have nothing to fear but fear itself. And Chuck Norris.'",
            "The original title for Alien vs. Predator was Alien and Predator vs Chuck Norris. The film was cancelled shortly after going into preproduction. No one would pay nine dollars to see a movie fourteen seconds long.",
            "Chuck Norris finished World of Warcraft.",
            "To be or not to be? That is the question. The answer? Chuck Norris.",
            "Chuck Norris's programs can pass the Turing Test by staring at the interrogator.",
            "Chuck Norris killed two stones with one bird.",
            "The class object inherits from Chuck Norris",
            "Each hair in Chuck Norris's beard contributes to make the world's largest DDOS.",
            "When Chuck Norris plays Monopoly, it affects the actual world economy.",
            "If you work in an office with Chuck Norris, don't ask him for his three-hole-punch."
    };

    public static String getJoke() {
        Random random = new Random();
        return mJokes[random.nextInt(mJokes.length)];
    }
}

