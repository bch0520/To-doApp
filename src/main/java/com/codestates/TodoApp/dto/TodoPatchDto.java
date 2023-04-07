package com.codestates.TodoApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoPatchDto {
    private Long todoId;
    private String  title;
    private Integer todo_order;
    private Boolean isCompleted;

}
