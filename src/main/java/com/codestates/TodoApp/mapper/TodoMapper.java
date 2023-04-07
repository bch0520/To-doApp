package com.codestates.TodoApp.mapper;

import com.codestates.TodoApp.dto.TodoPatchDto;
import com.codestates.TodoApp.dto.TodoPostDto;
import com.codestates.TodoApp.dto.TodoResponseDto;
import com.codestates.TodoApp.todo.Todo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoPostDtotoTodo(TodoPostDto todoPostDto);
    Todo todoPatchDtotoTodo(TodoPatchDto todoPatchDto);
    TodoResponseDto todoToTodoResponseDto(Todo todo);
    }


