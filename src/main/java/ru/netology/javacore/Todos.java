package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    Set<Task> tasks;
    StringBuilder stringBuilder;

    public Todos() {
        this.tasks = new HashSet<>();
    }

    public void addTask(String task) {
        tasks.add(new Task(task));
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
            stringBuilder.append('\t');
        }
        return stringBuilder.toString();
    }
}
