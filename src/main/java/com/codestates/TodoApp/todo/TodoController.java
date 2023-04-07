package com.codestates.TodoApp.todo;

import com.codestates.TodoApp.ToDoAppApplication;
import com.codestates.TodoApp.dto.TodoPatchDto;
import com.codestates.TodoApp.dto.TodoPostDto;
import com.codestates.TodoApp.dto.TodoResponseDto;
import com.codestates.TodoApp.mapper.TodoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.lang.reflect.Member;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v5/todos")
@Validated
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper mapper;
    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoDto) {

        Todo todo = mapper.todoPostDtotoTodo(todoDto);

        Todo response = todoService.createTodo(todo);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") @Positive long todoId,
                                    @Valid @RequestBody TodoPatchDto todoPatchDto) {
        todoPatchDto.setTodoId(todoId);

        Todo response = todoService.updateTodo(mapper.todoPatchDtotoTodo(todoPatchDto));

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{todo-id}")
    public  ResponseEntity getTodo(@PathVariable("todo-id") @Positive long todoId) {

        Todo response = todoService.readTodo(todoId);
        return new ResponseEntity<>(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos() {

        List<Todo> todos = todoService.readTodos();

        List<TodoResponseDto> response =
                todos.stream()
                        .map(todo -> mapper.todoToTodoResponseDto(todo))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") @Positive long todoId) {

        System.out.println("# delete todo");
        todoService.deleteTodo(todoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTodos() {
        System.out.println("# delete todos");
        todoService.deleteTodos();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
