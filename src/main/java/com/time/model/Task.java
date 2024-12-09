package com.time.model;

public class Task {
    private int id;
    private int userId;
    private String taskName;
    private String dueDate;

    public Task(int id, int userId, String taskName, String dueDate) {
        this.id = id;
        this.userId = userId;
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
