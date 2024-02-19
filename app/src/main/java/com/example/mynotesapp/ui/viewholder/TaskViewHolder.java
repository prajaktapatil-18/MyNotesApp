package com.example.mynotesapp.ui.viewholder;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.datapassintent.databinding.TaskItemLayoutBinding;
import com.example.mynotesapp.listener.TaskClickListener;
import com.example.mynotesapp.model.TaskModel;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    private TaskItemLayoutBinding itemLayoutBinding;

    public TaskViewHolder(TaskItemLayoutBinding binding) {
        super(binding.getRoot());
        this.itemLayoutBinding = binding;
    }

    public void bindDataToTask(TaskModel model, TaskClickListener clickListener) {
        itemLayoutBinding.tvTaskTitle.setText(model.getTaskTitle());
        itemLayoutBinding.tvDescription.setText(model.getDescription());
        itemLayoutBinding.tvDate.setText(model.getDate());
        itemLayoutBinding.tvTime.setText(model.getTime());
        itemLayoutBinding.crdTaskPoster.setOnClickListener(v -> {
                    clickListener.OnTaskClick(model);
                }
        );
        itemLayoutBinding.ivDeleteTask.setOnClickListener(v -> {
            clickListener.performDeleteAction(model);
        });
    }
}