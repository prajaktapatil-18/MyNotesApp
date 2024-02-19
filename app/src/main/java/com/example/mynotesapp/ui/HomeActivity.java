package com.example.mynotesapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datapassintent.R;
import com.example.datapassintent.databinding.ActivityHomePageBinding;
import com.example.mynotesapp.adapter.TaskAdapter;
import com.example.mynotesapp.listener.TaskClickListener;
import com.example.mynotesapp.model.TaskModel;
import com.example.mynotesapp.ui.viewmodel.TaskViewModel;
import com.example.mynotesapp.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements TaskClickListener {

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private ActivityHomePageBinding pageBinding;

    private TaskViewModel taskViewModel;
    private ArrayList<TaskModel> taskModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageBinding = DataBindingUtil.setContentView(this, R.layout.activity_home_page);
        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        setUpRecyclerView();
        taskViewModel.getRoutineList().observe(this, listOfTask -> {
            taskModelList.clear();
            taskModelList.addAll(listOfTask);
            updateUI(taskModelList);
        });
        pageBinding.fabAddTask.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
        });
    }

    private void updateUI(List<TaskModel> taskModelList) {
        if (taskModelList.isEmpty()) {
            pageBinding.tvNoTaskDesc.setVisibility(View.VISIBLE);
            pageBinding.recycleView.setVisibility(View.GONE);
        } else {
            pageBinding.tvNoTaskDesc.setVisibility(View.GONE);
            pageBinding.recycleView.setVisibility(View.VISIBLE);
        }
    }

    private void setUpRecyclerView() {
        taskAdapter = new TaskAdapter(this, taskModelList, this);
        pageBinding.recycleView.setAdapter(taskAdapter);
        pageBinding.recycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void OnTaskClick(TaskModel taskModel) {
        Constants.showToast(this, "Task clicked " + taskModel.getTaskTitle());
    }

    @Override
    public void performDeleteAction(TaskModel taskModel) {
        taskViewModel.delete(taskModel);
    }
}