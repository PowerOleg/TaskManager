package ru.netology.javacore;

public class CommandAdd implements Command {
    @Override
    public void execute(String task) {
    Todos.getInstance().addTask(task);
    }
}
