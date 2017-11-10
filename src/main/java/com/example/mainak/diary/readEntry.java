package com.example.mainak.diary;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class readEntry extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_entry);

        String q= getIntent().getStringExtra("query");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref= database.getReference(q);
        tv1 = (TextView)findViewById(R.id.textView4);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tv1.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Snackbar.make(getWindow().getDecorView().getRootView(),"Oops! We have a Problem.",Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(readEntry.this, DiaryActivity.class);
        // set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(i);
        //super.onBackPressed();
    }
}
