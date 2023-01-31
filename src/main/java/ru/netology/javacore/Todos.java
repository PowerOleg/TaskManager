package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {                //данный класс реализован как паттерн Singleton
    private static Todos todos;
    protected Set<Task> tasks = new HashSet<>();
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
        tasks.removeIf(n -> n.getTask().equalsIgnoreCase(task));
    }

    public String getAllTasks() {
        stringBuilder = new StringBuilder();
        List<String> taskList = tasks.stream().map(n -> n.getTask()).collect(Collectors.toList());
        taskList.sort(Comparator.comparing(n -> n));
        Iterator<String> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
