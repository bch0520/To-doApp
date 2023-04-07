package com.codestates.TodoApp.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // 해당클래스 엔티티 클래스로 인식
public class Todo {
    @Id  // 해당 클래스 엔티티 클래스로 인식
    @GeneratedValue // 기본키가 되는 식별자 자동 설정
    private Long todoId;
    private String title;
    private Integer todo_order;
    private Boolean completed;

}
