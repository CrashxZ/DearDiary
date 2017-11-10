package com.example.mainak.diary;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mainak on 29-10-2017.
 */

public class Information extends Fragment {

    View v;
    TextView tv1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.information_layout,container,false);
        SharedPreferences pref = this.getActivity().getSharedPreferences("Crash",Context.MODE_PRIVATE);
        tv1 = (TextView)v.findViewById(R.id.textView8);
        String name = pref.getString("name","");

        tv1.setText("I'll protect Your Diary, "+name+"!");



        return v;
    }
}
