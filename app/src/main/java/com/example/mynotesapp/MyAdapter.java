package com.example.mynotesapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.example.datapassintent.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<TaskInfo> list;

    public MyAdapter(Context context, ArrayList<TaskInfo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {


        TaskInfo taskInfo = list.get(position);
        holder.task.setText(taskInfo.getTitleTask());
        holder.dateGater.setText(taskInfo.getDate());
        holder.timeGater.setText(taskInfo.getTime());
        holder.despGater.setText(taskInfo.getTitleDesp());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //        TextView date , time,
        TextView task, dateGater, timeGater, despGater;
//        EditText taskTitle, taskDesp;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

//date = itemView.findViewById(R.id.date);
//time = itemView.findViewById(R.id.time);
//taskTitle = itemView.findViewById(R.id.taskTitle);
//taskDesp = itemView.findViewById(R.id.taskDesp);
            task = itemView.findViewById(R.id.task);
            dateGater = itemView.findViewById(R.id.dateGater);
            timeGater = itemView.findViewById(R.id.timeGater);
            despGater = itemView.findViewById(R.id.despGater);


        }
    }
}