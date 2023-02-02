package ru.netology.javacore;

import java.util.Iterator;
import java.util.ListIterator;

public class CommandRestore implements Command {
    @Override
    public void execute(String task) {
        Todos todos = Todos.getInstance();
        int count = todos.tasks.size();
        ListIterator<Task> iterator = todos.tasks.listIterator();
                Task task1 = iterator.previous();                                                       //!!!
        int loopNumber;
        System.out.println(count);                                                              //d

        while (true) {
//            for (Task task1 : todos.tasks) {
//            for (int i = count; i > ; i--) {                            //пробегаем с конца в начало
//
//            }



//            }
//            loopNumber--;
        }

    }
}
