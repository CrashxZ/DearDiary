package com.example.mainak.diary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class getEntries extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    SharedPreferences sp;
    DatabaseReference ref;
    ListView lv1;
    ArrayAdapter list1;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_entries);
        sp = getApplicationContext().getSharedPreferences("Crash", MODE_PRIVATE);
        name = sp.getString("name","");
        ref = database.getReference(name);
        lv1 = (ListView)findViewById(R.id.listtitle);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                try {
                    Map<String,String> ctsmap = (Map<String,String>)dataSnapshot.getValue();
                    Set<String> keys = ctsmap.keySet();
                    //Iterator<String> i = keys.iterator();
                    int n=0;
                    System.out.println("mark x = " + keys.size());

                    String list[] = new String[keys.size()];
                    System.out.println("mark 1 = " + keys.size());
                    for(String s : keys)
                    {
                        list[n++]= s;
                    }
                    list1 = new ArrayAdapter<String>(getEntries.this,android.R.layout.simple_list_item_1,list);

                    lv1.setAdapter(list1);

//                for (int i = 0; i < lv1.getChildCount(); i++) {
//                    ((TextView)lv1.getChildAt(i)).setTextColor(getResources().setColor(R.color.colorText,getTheme()));
//                }

                    lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String query = lv1.getItemAtPosition(position).toString();
                            query = name+"/"+query;
                            Intent i = new Intent(getEntries.this,readEntry.class);
                            i.putExtra("query",query);
                            startActivity(i);
                        }
                    });
                } catch(Exception e){
                    Toast.makeText(getApplicationContext(),"No Entries Available",Toast.LENGTH_LONG).show();
                    finish();
                }

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
}
