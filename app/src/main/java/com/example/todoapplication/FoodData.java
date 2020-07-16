package com.example.todoapplication;

public class FoodData {
    private String taskName;
    private String taskDescription;
    private String taskDeadline;
    private String key;

    public FoodData(String s, String toString, String string, String imageUrl){}


    public FoodData(String taskName, String taskDescription, String taskDeadline) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDeadline = taskDeadline;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskDeadline() {
        return taskDeadline;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
