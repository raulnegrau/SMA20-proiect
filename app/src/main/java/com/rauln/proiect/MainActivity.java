package com.rauln.proiect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView title;
    private DatabaseReference reference;
    private RecyclerView recyclerView;
    ArrayList<MyListClass> myList;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitleDate();

        recyclerView = findViewById(R.id.ourlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myList = new ArrayList<MyListClass>();

        reference = FirebaseDatabase.getInstance().getReference().child("MyList");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    MyListClass list = dataSnapshot1.getValue(MyListClass.class);
                    myList.add(list);
                }
                listAdapter = new ListAdapter(MainActivity.this, myList);
                recyclerView.setAdapter(listAdapter);
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setTitleDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String data = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()).toString();

        title = (TextView) findViewById(R.id.pagetitle);
        title.setText(data);
    }
}