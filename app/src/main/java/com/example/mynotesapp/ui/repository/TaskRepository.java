package com.example.mynotesapp.ui.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mynotesapp.db.TaskDAO;
import com.example.mynotesapp.db.TaskDatabase;
import com.example.mynotesapp.model.TaskModel;

import java.util.List;

public class TaskRepository {

    static long maxIDCount;
    private final TaskDAO dao;
    private final LiveData<List<TaskModel>> listOfTask;

    public TaskRepository(Application application) {
        TaskDatabase database = TaskDatabase.getInstance(application);
        dao = database.taskDao();
        listOfTask = dao.getListOfTask();
    }

    public long insert(TaskModel model) {
        new InsertRoutineAsyncTask(dao).execute(model);
        return maxIDCount;
    }

    public void delete(TaskModel model) {
        new DeleteRoutineAsyncTask(dao).execute(model);
    }

    public LiveData<List<TaskModel>> getListOfTask() {
        return listOfTask;
    }


    private static class InsertRoutineAsyncTask extends AsyncTask<TaskModel, Void, Long> {
        private final TaskDAO dao;

        private InsertRoutineAsyncTask(TaskDAO dao) {
            this.dao = dao;
        }

        @Override
        protected Long doInBackground(TaskModel... model) {
            // below line is use to insert our modal in dao.
            return dao.insert(model[0]);
        }

        @Override
        protected void onPostExecute(Long integer) {
            maxIDCount = integer;
        }
    }

    private static class DeleteRoutineAsyncTask extends AsyncTask<TaskModel, Void, Void> {
        private final TaskDAO dao;

        private DeleteRoutineAsyncTask(TaskDAO dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(TaskModel... models) {
            dao.delete(models[0]);
            return null;
        }
    }
}
