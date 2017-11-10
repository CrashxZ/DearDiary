package com.example.mainak.diary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity {


    EditText name;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        name = (EditText)findViewById(R.id.editText);
        pass = (EditText)findViewById(R.id.editTextpass);
    }
    public void register(View v)
    {
        String n = name.getText().toString();
        String p = pass.getText().toString();
        if(!(n.isEmpty())&&!(p.isEmpty()))
        {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("Crash",MODE_PRIVATE);

            SharedPreferences.Editor edit = pref.edit();

            edit.putString(n,p);
            //edit.putString("pass",p);

            edit.commit();
            Snackbar s = Snackbar.make(v,"Registered Successfully", Snackbar.LENGTH_LONG);
            s.setAction("BACK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            s.show();
        }
        else
        {
            Snackbar.make(v,"Enter Valid Details",Snackbar.LENGTH_LONG).show();
        }



    }

}
