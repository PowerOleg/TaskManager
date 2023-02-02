package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private static Todos todos;
    protected Deque<Task> tasks = new ArrayDeque<>();
    private Todos() {}

    public static synchronized Todos getInstance() {
        if (todos == null) {
            todos = new Todos();
        }
        return todos;
    }

    public boolean addTask(String task) {
        if (tasks.size() < 7) {
            tasks.add(new Task(task));
            return true;
        }
        return false;
    }

    public void removeTask(String task) {
        Task deletedTask = null;
        for (Task iteratorTask : tasks) {
            if (task.equalsIgnoreCase(iteratorTask.getTask())) {
                iteratorTask.setDeleted(true);
                deletedTask = iteratorTask;
            }
        }
        if (deletedTask != null) {
            tasks.remove(deletedTask);
            tasks.add(deletedTask);
        }
    }

    public String getAllTasks() {
        return tasks.stream().filter(n -> !n.isDeleted()).map(n -> n.getTask())
                .sorted().distinct().collect(Collectors.joining(" "));
    }
}
