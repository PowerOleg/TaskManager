package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {
    Todos todos;

    @BeforeEach
    public void init() {
        todos = new Todos();
    }

    @Test
    public void testAddTask7False() {
        todos.addTask("прыгать");
        todos.addTask("лежать на спине");
        todos.addTask("лежать на животе");
        todos.addTask("лежать и есть");
        todos.addTask("идти на кухню");
        todos.addTask("сходить погулять");
        Assertions.assertTrue(todos.addTask("накормить кота"));
        Assertions.assertFalse(todos.addTask("поиграть в баскетбол"));
    }

    @Test
    public void testAddTaskEqualsPositive() {
        String expected = "[прыгать]";
        todos.addTask("прыгать");
        String result = todos.tasks.toString();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testRemoveTaskPositive() {
        String expected = "[]";
        todos.addTask("прыгать");
        todos.removeTask("прыгать");
        String result = todos.tasks.toString();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetAllTasksPositive() {
        String expected = "бегать по пляжу заправить кровать накормить кота плавать почистить зубы сходить в театр сходить на турнички ";
        todos.addTask("бегать по пляжу");
        todos.addTask("сходить на турнички");
        todos.addTask("плавать");
        todos.addTask("почистить зубы");
        todos.addTask("сходить в театр");
        todos.addTask("заправить кровать");
        todos.addTask("накормить кота");
        Assertions.assertEquals(expected, todos.getAllTasks());
    }
}