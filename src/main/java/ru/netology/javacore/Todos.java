package ru.netology.javacore;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class Todos {
    public static final int MAX_TASKS = 7;
    protected Deque<Task> tasks = new ArrayDeque<>();

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
        return tasks.stream().filter(n -> !n.isDeleted()).map(Task::getTask)
                .sorted().distinct().collect(Collectors.joining(" "));
    }
}
