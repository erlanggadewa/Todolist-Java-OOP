package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {
    private TodoList[] data = new TodoList[5];

    private boolean isFull() {
        var isFull = true;
        for (TodoList datum : this.data) {
            if (datum == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    private void resizeIfFull() {
        if (isFull()) {
            var temp = this.data;
            this.data = new TodoList[data.length * 2];
            System.arraycopy(temp, 0, data, 0, temp.length);
        }
    }


    @Override
    public TodoList[] getAll() {
        return this.data;
    }

    @Override
    public void add(TodoList todoList) {
        resizeIfFull();

        // * Add data in array that has null value and stop iteration
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == null) {
                this.data[i] = todoList;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        // * Check if number is valid
        if (number < 1 || number > this.data.length)
            return false;


        if (this.data[number - 1] == null)
            return false;


        for (int i = number - 1; i < this.data.length; i++) {
            if (i == this.data.length - 1) {
                this.data[i] = null;
            } else {
                this.data[i] = this.data[i + 1];
            }
        }
        return true;
    }
}
