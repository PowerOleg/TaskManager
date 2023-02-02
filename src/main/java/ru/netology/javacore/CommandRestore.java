package ru.netology.javacore;

public class CommandRestore implements Command {
    @Override
    public void execute(String task) {
        Todos todos = Todos.getInstance();
        Task task1 = todos.tasks.pollLast();
        task1.setDeleted(!task1.isDeleted());
        todos.tasks.addFirst(task1);
    }
}
