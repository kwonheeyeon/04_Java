package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Todo;

public class TodoListDaoImpl implements TodoListDao{
	private final String FILE_PATH = "/io_test/todoList.dat";
	
	private List<Todo> todoList = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	public TodoListDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				todoList = (ArrayList<Todo>)ois.readObject();
			} finally {
				if(ois != null) ois.close();
			}
		}else {
			todoList = new ArrayList<Todo>();
		}
	}
	
	// --------------------------------------------------------------------------------------------
	
	@Override
	public List<Todo> getTodoList() {
		
		return todoList;
	}
	
	// --------------------------------------------------------------------------------------------
	
	@Override
	public void saveFile() throws IOException{
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(todoList);
		}finally {
			if(oos != null) oos.close();
		}
	}
}
