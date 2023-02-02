package ru.netology.javacore;

public class Task {
    protected final String task;
    protected boolean deleted = false;

    public Task(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return task;
    }
}
