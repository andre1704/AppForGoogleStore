package com.sdacademy.slowinski.andrzej.appforgooglestore.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sdacademy.slowinski.andrzej.appforgooglestore.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BatteryFragment extends Fragment {

    private Context context;

    @BindView(R.id.battery_percentage_text)
    TextView batteryTextView;

    public BatteryFragment() {
        // Required empty public constructor
    }

    public void onAttach(Context context){
        super.onAttach(context);
        this.context=context;
    }


    public int getPercentageBattery(Context context) {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);


        return level;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_baterry, container, false);
        ButterKnife.bind(this,view);
        String batteryPrc= String.valueOf(getPercentageBattery(context));
        batteryTextView.setText(batteryPrc);
        // Inflate the layout for this fragment
        return view;
    }

}
