package ru.netology.javacore;

public class CommandRemove implements Command {
    @Override
    public void execute(String task) {
        Todos.getInstance().removeTask(task);
    }
}
