package com.codestates.TodoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoResponseDto {
    private Long todoId;
    private String title;
    private Integer todo_order;
    private Boolean completed;
}
