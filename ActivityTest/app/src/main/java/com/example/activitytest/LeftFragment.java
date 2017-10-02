package com.example.activitytest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/9/7.
 */

public class LeftFragment extends Fragment {
    private static final String TGA = "RightFrame";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d(TGA,"onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TGA,"onCreate");
    }



    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TGA,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TGA,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TGA,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TGA,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TGA,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TGA,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TGA,"onDetach");
    }
}
