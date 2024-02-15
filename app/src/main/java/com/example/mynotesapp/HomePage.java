package com.example.mynotesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.datapassintent.R;
import com.example.datapassintent.databinding.ActivityMainBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
//import android.widget.Toolbar;

public class HomePage extends AppCompatActivity {


    Toolbar toolbar;
    TextView date, time;
    EditText taskTitle;
    EditText taskDesp;
    ImageButton addNote;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        addNote = findViewById(R.id.addNote);


        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        taskTitle = findViewById(R.id.taskTitle);
        taskDesp = findViewById(R.id.taskDesp);


        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, CreateNew_Task.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.theme) {
            Toast.makeText(this, "try again", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.deleteTask) {
            Toast.makeText(this, "deleted all task", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.setting) {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.exit) {
            finish();
        }
        return true;
    }
}