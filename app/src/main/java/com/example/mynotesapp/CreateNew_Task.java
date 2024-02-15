package com.example.mynotesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;


import com.example.datapassintent.R;
import com.example.datapassintent.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CreateNew_Task extends AppCompatActivity {


    Button addTask;

    TextView date, time;
    ImageButton calendarD, clock;

    RecyclerView recyclerView;
    ActivityMainBinding binding;
    int year;
    int month;
    int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_task);
        getSupportActionBar().hide();
        calendarD = findViewById(R.id.calender);
        clock = findViewById(R.id.clock);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        addTask = findViewById(R.id.addTask);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        final Calendar calendar = Calendar.getInstance();
        calendarD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH + 1);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(CreateNew_Task.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        date.setText(day + "/" + (month + 1) + "/" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();


            }
        });

        Calendar calendar1 = Calendar.getInstance();
        int hours = calendar1.get(Calendar.HOUR);
        int minutes = calendar1.get(Calendar.MINUTE);
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(CreateNew_Task.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int minute) {
                        time.setText(hours + ":" + minute);

                    }
                }, hours, minutes, false);
                timePickerDialog.show();


            }
        });

    }
}