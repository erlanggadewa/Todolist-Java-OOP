package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    public final TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = this.todoListRepository.getAll();
        System.out.println("\n===== TODO LIST =====");

        if (model[0] == null) System.out.println("Todolist kosong");

        for (int i = 0; i < model.length; i++) {
            if (model[i] != null)
                System.out.println(i + 1 + ". " + model[i].getTodo());
        }

    }

    @Override
    public void addTodoList(String todo) {
        todoListRepository.add(new TodoList(todo));
        System.out.println("Successfully added `" + todo + "` to your todo list");
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean isRemoved = todoListRepository.remove(number);

        if (isRemoved)
            System.out.println("Successfully removed number " + number + " from your todo list");
        else
            System.out.println("Failed to remove number " + number + " from your todo list");
    }
}
