package com.example.mynotesapp.listener;

import com.example.mynotesapp.model.TaskModel;

public interface TaskClickListener {
    void OnTaskClick(TaskModel taskModel);

    void performDeleteAction(TaskModel taskModel);
}
