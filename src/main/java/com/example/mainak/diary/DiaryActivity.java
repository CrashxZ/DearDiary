package com.example.mainak.diary;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class DiaryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Bundle b;
    String s;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        b = getIntent().getExtras();
        sp =  getApplicationContext().getSharedPreferences("Crash",MODE_PRIVATE);
        s = sp.getString("name","");
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.contentf,new begin()).commit();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome! :)", Snackbar.LENGTH_LONG)
                        .setAction("BACK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(DiaryActivity.this,DiaryActivity.class);
                                startActivity(i);
                            }
                        }).show();

                FragmentManager fm = getFragmentManager();
                addEntry ad = new addEntry();

//                b.putString("name",s);
//                ad.setArguments(b);
                fm.beginTransaction().replace(R.id.contentf,ad).commit();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.diary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            return true;
        }else if (id == R.id.action_settings2)
        {
            Intent i = new Intent(DiaryActivity.this,getEntries.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fm = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_about1) {
            // Handle the camera action
            fm.beginTransaction().replace(R.id.contentf,new about()).commit();
            Toast.makeText(getApplicationContext(),"About",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_guide1) {
            fm.beginTransaction().replace(R.id.contentf,new guide()).commit();
            Toast.makeText(getApplicationContext(),"Guide",Toast.LENGTH_LONG).show();

        }  else if (id == R.id.nav_info1) {
            fm.beginTransaction().replace(R.id.contentf,new Information()).commit();
            Toast.makeText(getApplicationContext(),"Info",Toast.LENGTH_LONG).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void viewEntries(View v){
        Intent i = new Intent(DiaryActivity.this,getEntries.class);
        startActivity(i);
    }
}
