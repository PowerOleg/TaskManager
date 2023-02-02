package ru.netology.javacore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CommandRestore implements Command {
    @Override
    public void execute(String task) {
        Todos todos = Todos.getInstance();
//        int elementNumber = todos.tasks.size()-1;

//            for (int i = count-1; i < 0; i--) {                            //пробегаем с конца в начало
                Task task1 = todos.tasks.pollLast();
                task1.setDeleted(!task1.isDeleted());
                todos.tasks.addFirst(task1);
//            }

//            System.out.println(iterator.hasPrevious());



//            task1.setDeleted();









//        int loopNumber;
//        System.out.println(count);                                                              //d


//            for (Task task1 : todos.tasks) {




//            }
//            loopNumber--;


    }
}
