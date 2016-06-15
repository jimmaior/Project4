package com.udacity.gradle.androidlib;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class JokerFragment extends Fragment {

    private static final String TAG = JokerFragment.class.getSimpleName();

    public JokerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_joker, container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokerActivity.JOKER_KEY);
        TextView textEdit = (TextView) view.findViewById(R.id.tv_joke_text);
        if (joke.length() >0) {
            textEdit.setText(joke);
        }
        return view;
    }


}
