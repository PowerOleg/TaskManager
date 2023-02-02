package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    protected static Todos todos;
    protected Deque<Task> tasks = new ArrayDeque<>();
    protected int numberOfTasks = 7;
    private Todos() {}

    public static synchronized Todos getInstance() {
        if (todos == null) {
            todos = new Todos();
        }
        return todos;
    }

    public boolean addTask(String task) {
        if (tasks.size() < numberOfTasks) {
            tasks.add(new Task(task));
            return true;
        }
        return false;
    }

    public boolean removeTask(String task) {
        boolean result = false;
        Task deletedTask = null;
        for (Task iteratorTask : tasks) {
            if (task.equalsIgnoreCase(iteratorTask.getTask())) {
                iteratorTask.setDeleted(true);
                deletedTask = iteratorTask;
                result = true;
            }
        }
        if (deletedTask != null) {
            tasks.remove(deletedTask);
            tasks.add(deletedTask);
        }
        return result;
    }

    public String getAllTasks() {
        return tasks.stream().filter(n -> !n.isDeleted()).map(n -> n.getTask())
                .sorted().distinct().collect(Collectors.joining(" "));
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }
    public void setNumberOfTasks(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }
}
