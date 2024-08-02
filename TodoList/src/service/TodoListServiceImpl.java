package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	public int checkComplete() {
		int checkComplete = 0;
		
		for(Todo todo : dao.getTodoList()) {
			if(todo.isComplete() == true)
				checkComplete++;
		}
		
		return checkComplete;
	}
	
	@Override
	public String formattedDateTime(int index) {
		List<Todo> todoList = dao.getTodoList();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = todoList.get(index).getRegDate().format(formatter);
		
		return formattedDateTime;
	}
	
	@Override
	public void todoAdd(String title, String detail) throws IOException {
		LocalDateTime regDate = LocalDateTime.now();
		
		Todo todo = new Todo(title, detail, false, regDate);
		dao.getTodoList().add(todo);
		
		dao.saveFile();
	}
	
	@Override
	public char checkComplete(int index) {
		if(dao.getTodoList().get(index).isComplete() == true) return 'O';
		else return 'X';
	}
	
	@Override
	public void todoComplete(int index) throws IOException {
		Todo todo = dao.getTodoList().get(index);
		
		if(todo.isComplete() == true)
			todo.setComplete(false);
		else
			todo.setComplete(true);
		
		dao.saveFile();
	}
	
	@Override
	public void todoUpdate(int index, String title, String detail) throws IOException {
		Todo todo = dao.getTodoList().get(index);
		
		todo.setTitle(title);
		todo.setDetail(detail);
		
		dao.saveFile();
	}
	
	@Override
	public void todoDelete(int index) throws IOException {
		dao.getTodoList().remove(index);
		
		dao.saveFile();
	}
}
