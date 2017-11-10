package com.example.mainak.diary;


import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Mainak on 29-10-2017.
 */

public class name {

    SharedPreferences sp;
    String name;
    public name(Context c){

        sp = c.getSharedPreferences("Crash", MODE_PRIVATE);
    }


}
