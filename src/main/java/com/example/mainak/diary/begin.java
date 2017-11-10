package com.example.mainak.diary;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mainak on 29-10-2017.
 */

public class begin extends Fragment {

    View v;
    //TextView tv1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.begin,container,false);
        //tv1 = (TextView)v.findViewById(R.id.getentry);


        return v;
    }
}
