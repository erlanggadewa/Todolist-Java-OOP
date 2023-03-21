package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    private final TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        label:
        while (true) {
            todoListService.showTodoList();

            System.out.println("\nMENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = InputUtil.input("Pilih");

            switch (input) {
                case "1":
                    addTodoList();
                    break;
                case "2":
                    removeTodoList();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("Pilihan tidak dimengerti");
                    break;
            }


        }
    }

    public void addTodoList() {
        System.out.println("\nMENAMBAH TODOLIST");

        String todo = InputUtil.input("Todo (x Jika Batal)");

        if (!todo.equals("x"))
            todoListService.addTodoList(todo);

    }

    public void removeTodoList() {
        System.out.println("\nMENGHAPUS TODOLIST");

        String number = InputUtil.input("Nomor yang Dihapus (x Jika Batal)");

        if (!number.equals("x"))
            todoListService.removeTodoList(Integer.valueOf(number));
    }
}
