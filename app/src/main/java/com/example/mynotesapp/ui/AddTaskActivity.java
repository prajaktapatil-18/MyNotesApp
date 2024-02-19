package com.example.mynotesapp.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.datapassintent.R;
import com.example.datapassintent.databinding.ActivityCreateNewTaskBinding;
import com.example.mynotesapp.listener.TaskClickListener;
import com.example.mynotesapp.model.DateModel;
import com.example.mynotesapp.model.TaskModel;
import com.example.mynotesapp.model.TimeModel;
import com.example.mynotesapp.ui.viewmodel.TaskViewModel;
import com.example.mynotesapp.utils.Constants;

import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity{

    private ActivityCreateNewTaskBinding binding;
    private TimeModel timeModel;
    private DateModel dateModel;
    String timeToNotify;

    private TaskViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_new_task);
        getSupportActionBar().hide();
        viewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        binding.ivSelectTime.setOnClickListener(v -> showTimerPickerDialog());
        binding.ivSelectDate.setOnClickListener(v -> showDatePickerDialog());
        binding.tvDate.setOnClickListener(v -> showDatePickerDialog());
        binding.tvTime.setOnClickListener(v -> showTimerPickerDialog());

        binding.ivPriority.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(this, binding.ivPriority);
            popupMenu.getMenuInflater().inflate(R.menu.priority_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(menuItem -> {
                binding.tvPriority.setText(menuItem.getTitle());
                Constants.showToast(AddTaskActivity.this, menuItem.getTitle().toString());
                return true;
            });
            popupMenu.show();
        });

        binding.btnTaskDone.setOnClickListener(v -> {
            String time = binding.tvTime.getText().toString();
            String date = binding.tvDate.getText().toString();
            String task = binding.etRoutine.getText().toString();
            String desc = binding.etDecs.getText().toString();
            if (time.isEmpty()) {
                binding.tvTime.setError(getString(R.string.this_field_required));
                return;
            }
            if (date.isEmpty()) {
                binding.tvDate.setError(getString(R.string.this_field_required));
                return;
            }
            if (task.isEmpty()) {
                binding.etRoutine.setError(getString(R.string.this_field_required));
                return;
            }
            if (desc.isEmpty()) {
                binding.etDecs.setError(getString(R.string.this_field_required));
                return;
            }
            TaskModel taskModel = new TaskModel();
            taskModel.setTaskTitle(task);
            taskModel.setDescription(desc);
            taskModel.setDate(date);
            taskModel.setTime(time);
            viewModel.insert(taskModel);
            Constants.showToast(AddTaskActivity.this, getString(R.string.task_created));
            finish();
        });

    }


    private void showTimerPickerDialog() {
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker = new TimePickerDialog(this, (timePicker, selectedHour, selectedMinute) -> {
            Constants.printLog("selectedTime " + selectedHour + ":" + selectedMinute);
            timeToNotify = selectedHour + ":" + selectedMinute;
            timeModel = new TimeModel(selectedHour, selectedMinute, timeToNotify);
            binding.tvTime.setText(Constants.formatTime(selectedHour, selectedMinute));
        }, hour, minute, true);
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (datePicker, year1, month1, day1) -> {
            dateModel = new DateModel(year1, month1 + 1, day1);
            Constants.printLog("selectedDate " + day1 + "-" + month1 + "-" + year1);
            binding.tvDate.setText(day1 + "-" + (month1 + 1) + "-" + year1);
        }, year, month, day);
        datePickerDialog.show();
    }
}