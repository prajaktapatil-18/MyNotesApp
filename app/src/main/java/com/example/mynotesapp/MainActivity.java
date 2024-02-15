package com.example.mynotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.example.datapassintent.R;
import com.example.datapassintent.databinding.ActivityMainBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ActivityMainBinding binding;

    FirebaseFirestore firestore;
    ArrayList<TaskInfo> list;
    MyAdapter adapter;

    Button btnGo, addTask;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGo = findViewById(R.id.btnGo);
        addTask = findViewById(R.id.addTask);
        recyclerView = findViewById(R.id.recycleView);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//
        firestore = FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        adapter = new MyAdapter(this, list);


        getSupportActionBar().hide();

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}