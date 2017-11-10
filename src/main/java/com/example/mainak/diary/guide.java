package com.example.mainak.diary;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mainak on 29-10-2017.
 */

public class guide extends Fragment {

    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.guide,container,false);

        return v;
    }
}
