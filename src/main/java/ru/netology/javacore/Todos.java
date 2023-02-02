package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private static Todos todos;
    protected Deque<Task> tasks = new ArrayDeque<>();
    private StringBuilder stringBuilder;

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
        stringBuilder = new StringBuilder();
        List<String> taskList = tasks.stream().filter(n -> !n.isDeleted()).map(n -> n.getTask()).distinct().collect(Collectors.toList());
        taskList.sort(Comparator.comparing(n -> n));
        for (String s : taskList) {
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
