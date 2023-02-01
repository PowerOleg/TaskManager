package ru.netology.javacore;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Todos todos = Todos.getInstance();//new Todos();
        TodoServer server = new TodoServer(8989, todos);
        server.start();

//        ServerLogic serverLogic = new ServerLogic();
//        String[] commandTypeAndTask= serverLogic.parse("{ \"type\": \"ADD\", \"task\": \"Купить пирожок\" }");
//        System.out.println("01 " + Arrays.deepToString(commandTypeAndTask));


//        Command command = serverLogic.getCommandType(commandTypeAndTask[0]);
//        System.out.println("02 " + command);
//        System.out.println("03 " + todos.getAllTasks());
//        command.execute(commandTypeAndTask[1]);
//        System.out.println("04 " + todos.getAllTasks());
//        command.execute("task1");
//        command.execute("task2");
//
//
//
//        commandTypeAndTask= serverLogic.parse("{ \"type\": \"REMOVE\", \"task\": \"Купить пирожок\" }");
//        command = serverLogic.getCommandType(commandTypeAndTask[0]);
//        command.execute(commandTypeAndTask[1]);
//        System.out.println("05 " + todos.getAllTasks());
    }
}
