package com.example.mainak.diary;

import android.app.Fragment;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Mainak on 29-10-2017.
 */

public class addEntry extends Fragment {
0000009
    View v;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    EditText et1,title;
    Button add;
    DatabaseReference myRef;
    Intent i;
    String t;
    String name;
    SharedPreferences sp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.entry_layout,container,false);
        add = (Button) v.findViewById(R.id.button2);
        et1 = (EditText)v.findViewById((R.id.dataentry));
        title = (EditText)v.findViewById((R.id.editText6));

        sp =  getActivity().getSharedPreferences("Crash",MODE_PRIVATE);
        name = sp.getString("name","");
        //name = getArguments().getString("name");
        myRef = database.getReference(name);
        return v;
    }


    @Override
    public void onStart() {
        super.onStart();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                String entry = et1.getText().toString();
                t = title.getText().toString();
                myRef = myRef.child(t);
                myRef.setValue(entry);

                i = new Intent(getActivity(),readEntry.class);
                String query = name+"/"+t;
                i.putExtra("query",query);
                startActivity(i);


            }
        });


    }
}
