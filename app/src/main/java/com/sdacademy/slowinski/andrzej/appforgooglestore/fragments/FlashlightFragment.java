package com.sdacademy.slowinski.andrzej.appforgooglestore.fragments;


import android.content.Context;
import android.graphics.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.sdacademy.slowinski.andrzej.appforgooglestore.R;

import java.security.Policy;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlashlightFragment extends Fragment {

    private Context context;



    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public FlashlightFragment() {
        // Required empty public constructor
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick(R.id.buttonLightOff)
    public void turnOff(){
        try {
            turnOffFlash(context);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick(R.id.buttonLightOn)
    public void trunOn(){
        try {
            turnOnFlash(context);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void turnOnFlash(Context context) throws CameraAccessException {
        CameraManager cameraManager=(CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        String cameraID=cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraID,true);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)

    public void turnOffFlash(Context context) throws CameraAccessException {
        CameraManager cameraManager=(CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        String cameraID=cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraID,false);
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_flashlight, container, false);
        ButterKnife.bind(this, view);

        // Inflate the layout for this fragment
        return view;
    }

}
