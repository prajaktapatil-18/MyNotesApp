package com.example.mynotesapp.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mynotesapp.model.TaskModel;

import java.util.List;

@Dao
public interface TaskDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(TaskModel model);

    @Update
    void update(TaskModel model);

    @Delete
    void delete(TaskModel model);

    @Query("DELETE FROM task_table")
    void deleteRoutines();

    @Query("SELECT * FROM task_table ORDER BY id DESC")
    LiveData<List<TaskModel>> getListOfTask();

}