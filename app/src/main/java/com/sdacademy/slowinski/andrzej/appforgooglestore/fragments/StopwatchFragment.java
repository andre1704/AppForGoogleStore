package com.sdacademy.slowinski.andrzej.appforgooglestore.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sdacademy.slowinski.andrzej.appforgooglestore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment {


    public StopwatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stopwatch, container, false);
    }

}
