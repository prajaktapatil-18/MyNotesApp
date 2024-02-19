package com.example.mynotesapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mynotesapp.model.TaskModel;
import com.example.mynotesapp.ui.repository.TaskRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private final TaskRepository repository;
    private final LiveData<List<TaskModel>> listOfCreatedTask;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        listOfCreatedTask = repository.getListOfTask();
    }

    public long insert(TaskModel model) {
        return repository.insert(model);
    }

    public void delete(TaskModel model) {
        repository.delete(model);
    }

    public LiveData<List<TaskModel>> getRoutineList() {
        return listOfCreatedTask;
    }

}