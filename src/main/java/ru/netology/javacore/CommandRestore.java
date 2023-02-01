package ru.netology.javacore;

public class CommandRestore implements Command {
    @Override
    public void execute(String task) {
//        Todos.getInstance().addTask(task);
        System.out.println("restore");
    }
}
