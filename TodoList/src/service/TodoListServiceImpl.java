package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoListService{
	TodoListDao dao = null;
	
	public TodoListServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new TodoListDaoImpl();
	}
	
	@Override
	public List<Todo> getTodoList() {
		return dao.getTodoList();
	}
	
	@Override
	public void todoAdd(String title, String detail) throws IOException {
		LocalDateTime regDate = LocalDateTime.now();
		
		Todo todo = new Todo(title, detail, false, regDate);
		
		dao.saveFile();
	}
}
