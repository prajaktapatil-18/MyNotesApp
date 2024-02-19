package com.example.mynotesapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datapassintent.databinding.TaskItemLayoutBinding;
import com.example.mynotesapp.listener.TaskClickListener;
import com.example.mynotesapp.model.TaskModel;
import com.example.mynotesapp.ui.viewholder.TaskViewHolder;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private final Context context;
    private final List<TaskModel> taskModelList;
    private TaskClickListener clickListener;

    public TaskAdapter(Context context, List<TaskModel> taskModelList, TaskClickListener clickListener) {
        this.context = context;
        this.taskModelList = taskModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(TaskItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TaskModel model = taskModelList.get(position);
        holder.bindDataToTask(model, clickListener);
    }

    @Override
    public int getItemCount() {
        return taskModelList.size();
    }
}