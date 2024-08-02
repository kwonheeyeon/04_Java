package service;

import java.io.IOException;
import java.util.List;

import dto.Todo;

public interface TodoListService {

	List<Todo> getTodoList();

	void todoAdd(String title, String detail) throws IOException;

}
