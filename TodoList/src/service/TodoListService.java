package service;

import java.io.IOException;
import java.util.List;

import dto.Todo;

public interface TodoListService {

	List<Todo> getTodoList();

	int countComplete();
	
	String formattedDateTime(int index);
	
	void todoAdd(String title, String detail) throws IOException;
	
	char checkComplete(int index);

	void todoComplete(int index) throws IOException;

	void todoUpdate(int index, String title, String detail) throws IOException;

	void todoDelete(int index) throws IOException;

}
