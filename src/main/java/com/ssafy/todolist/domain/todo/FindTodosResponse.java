package com.ssafy.todolist.domain.todo;

import java.util.List;

public record FindTodosResponse(String message, List<TodoDTO> todos) {
}
