package ru.netology.javacore;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        Todos todos = new Todos();
//        TodoServer server = new TodoServer(8989, todos);
//        server.start();

        Todos todos = new Todos();
        todos.addTask("бегать по пляжу");
        todos.addTask("сходить на турнички");
        todos.addTask("плавать");
        todos.addTask("почистить зубы");
        todos.addTask("сходить в театр");
        todos.addTask("заправить кровать");
        todos.addTask("накормить кота");
        System.out.println(todos.getAllTasks());
        todos.removeTask("поесть");
        System.out.println(todos.getAllTasks());
    }
}
