package service;

import java.io.IOException;
import java.util.List;

import dto.Todo;

public interface TodoListService {

	List<Todo> getTodoList();

	int checkComplete();
	
	void todoAdd(String title, String detail) throws IOException;
	
	char checkComplete(int index);

	void todoComplete(int index) throws IOException;

	void todoUpdate(int index, String title, String detail) throws IOException;

	String formattedDateTime(int index);

	void todoDelete(int index) throws IOException;

}
