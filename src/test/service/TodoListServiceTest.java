package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
//        testShowTodoList();
//        testAddTodoList();
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.add(new TodoList("Belajar Java Dasar"));
        todoListRepository.add(new TodoList("Belajar Java OOP"));

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.showTodoList();

    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Collection");
        todoListService.addTodoList("Belajar Java Lambda");
        todoListService.addTodoList("Belajar Java Lombok");
        todoListService.addTodoList("Belajar Java Database");

        todoListService.showTodoList();

    }

    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Collection");
        todoListService.addTodoList("Belajar Java Lambda");
        todoListService.addTodoList("Belajar Java Lombok");
        todoListService.addTodoList("Belajar Java Database");

        System.out.println("DELETE TEST");
        todoListService.removeTodoList(1);
        todoListService.removeTodoList(2);
        todoListService.removeTodoList(3);
        todoListService.removeTodoList(7);
        todoListService.removeTodoList(-1);

        todoListService.showTodoList();
    }
}
