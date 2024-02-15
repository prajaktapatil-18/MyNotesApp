package com.example.mynotesapp;




public class TaskInfo {


    private String date;
    private String time;
    private String titleTask;
    private String titleDesp;

    public TaskInfo(String date, String time, String titleTask, String titleDesp) {
        this.date = date;
        this.time = time;
        this.titleTask = titleTask;
        this.titleDesp = titleDesp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitleTask() {
        return titleTask;
    }

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }

    public String getTitleDesp() {
        return titleDesp;
    }

    public void setTitleDesp(String titleDesp) {
        this.titleDesp = titleDesp;
    }

    public TaskInfo() {
    }
}
