package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {                //данный класс реализован как паттерн Singleton
    private static Todos todos;
    protected List<Task> tasks = new ArrayList<>();                                //3
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

    public void removeTask(String task) {                                                       //1
        for (Task iteratorTask : tasks) {
            System.out.println(iteratorTask);                                                   //d
            if (task.equalsIgnoreCase(iteratorTask.getTask())) {
                iteratorTask.setDeleted(true);
            }
        }
    }

    public String getAllTasks() {                                   //2
        stringBuilder = new StringBuilder();
        List<String> taskList = tasks.stream().filter(n -> !n.isDeleted()).map(n -> n.getTask()).distinct().collect(Collectors.toList());
        taskList.sort(Comparator.comparing(n -> n));
        Iterator<String> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
