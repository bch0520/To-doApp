package com.codestates.TodoApp.todo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public Todo createTodo(Todo todo) {

        Todo createdTodo = todo;
        return createdTodo;
    }

    public Todo updateTodo(Todo todo) {
        Todo updatedTodo = todo;
        return updatedTodo;
    }

    public Todo readTodo(long todoId) {
        Todo todo =
                new Todo(todoId, "운동하기", 1, false);
        return todo;
    }

    public List<Todo> readTodos() {

        List<Todo> todos = List.of(
                new Todo(1L, "운동하기", 1, false),
                new Todo(2L, "공부하기", 2, false)
            );
        return todos;
    }

    public void deleteTodo(long todoId) {

    }

    public void deleteTodos() {

    }
}
