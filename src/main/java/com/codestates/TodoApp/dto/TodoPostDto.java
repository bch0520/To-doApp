package com.codestates.TodoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TodoPostDto {
    private String title;
    private Integer todo_order;
    private Boolean completed;
}
