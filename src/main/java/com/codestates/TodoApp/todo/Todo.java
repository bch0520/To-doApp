package com.codestates.TodoApp.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private Long todoId;
    private String title;
    private Integer todo_order;
    private Boolean completed;

}
