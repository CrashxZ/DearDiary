package com.example.mainak.diary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sp;
    EditText n;
    EditText p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        n = (EditText)findViewById(R.id.editText);
        p = (EditText)findViewById(R.id.editText2);
        sp =  getApplicationContext().getSharedPreferences("Crash",MODE_PRIVATE);
    }
    public void openRegistration(View v)
    {
        Intent i = new Intent(LoginActivity.this,UserActivity.class);
        startActivity(i);
    }
    public void login(View v)
    {
        Snackbar s;
        s = Snackbar.make(v,"",Snackbar.LENGTH_INDEFINITE);
        String ename = n.getText().toString();
        String epass = p.getText().toString();

        if(sp.getString(ename,"")=="")
        {
            s = Snackbar.make(v,"Unregistered User",Snackbar.LENGTH_INDEFINITE);
       }
        else if(sp.getString(ename,"").equals(epass))
        {
            SharedPreferences.Editor  e = sp.edit();
            e.putString("name",ename);
            e.commit();
            Intent i = new Intent(LoginActivity.this,DiaryActivity.class);
            i.putExtra("name",ename);
            startActivity(i);
        }
        else{
            s = Snackbar.make(v,"Wrong Password",Snackbar.LENGTH_INDEFINITE);
        }
        s.show();
    }
}
