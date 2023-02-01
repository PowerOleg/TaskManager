package ru.netology.javacore;

import java.util.Objects;

public class Task {
    protected String task;
    protected boolean deleted = false;

    public Task() {
    }

    public Task(String task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task1 = (Task) o;
        return task.equals(task1.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task);
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
