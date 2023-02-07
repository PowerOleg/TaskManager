package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerLogic {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ClassForParsing parse(String clientRequest) {
        return gson.fromJson(clientRequest, ClassForParsing.class);
    }

    public Command getCommandType(String commandType, Todos todos) {
        switch (commandType) {
            case "ADD":
                return todos::addTask;
            case "REMOVE":
                return todos::removeTask;
            case "RESTORE":
                return (n) -> {
                    Task task1 = todos.tasks.pollLast();
                    if (task1 != null) task1.setDeleted(!task1.isDeleted());
                    todos.tasks.addFirst(task1);
                };
            default:
                return null;
        }
    }
}
