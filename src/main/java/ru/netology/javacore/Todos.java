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
        tasks.removeIf(n -> n.getTask().equals(task));
    }

    public String getAllTasks() {


    }

}
