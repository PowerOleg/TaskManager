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
        Task deletedTask = null;
        for (Task iteratorTask : tasks) {
            System.out.println(iteratorTask);                                                   //d
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

    public String getAllTasks() {                                   //2
        stringBuilder = new StringBuilder();
        System.out.println("0 " + tasks);
        List<String> taskList = tasks.stream()/*.filter(n -> !n.isDeleted())*/.map(n -> n.getTask())/*.distinct()*/.collect(Collectors.toList());
        taskList.sort(Comparator.comparing(n -> n));
        for (String s : taskList) {
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
