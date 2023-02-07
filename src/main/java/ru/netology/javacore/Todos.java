package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
//    protected static Todos todos;
    protected Deque<Task> tasks = new ArrayDeque<>();
    protected int MAX_TASKS = 7;
//    private Todos() {}

//    public static synchronized Todos getInstance() {
//        if (todos == null) {
//            todos = new Todos();
//        }
//        return todos;
//    }

    public boolean addTask(String task) {
        int count = 0;
        for (Task t : tasks) {
            if (!t.isDeleted()) {
                count++;
            }
        }
        if (count < MAX_TASKS) {
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

    public int getMAX_TASKS() {
        return MAX_TASKS;
    }
    public void setMAX_TASKS(int maxTasks) {
        this.MAX_TASKS = maxTasks;
    }
}
