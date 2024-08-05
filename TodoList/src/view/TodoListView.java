package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dto.Todo;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {
	private TodoListService service = null;
	private BufferedReader br = null;
	
	public TodoListView() {
		try {
			service = new TodoListServiceImpl();
			br = new BufferedReader(new InputStreamReader(System.in));
		}catch(Exception e) {
			System.out.println("### 프로그램 실행 중 오류 발생 ###");
			e.printStackTrace();	
			System.exit(0);
		}
	}
	
	// --------------------------------------------------------------------------------------------
	
	public void mainMenu() {
		int input = 0;
		
		do {
			try {
				input = selectMenu();
				
				switch(input) {
				case 1: todoListFullView(); break;
				case 2: todoDetailView(); break;
				case 3: todoAdd(); break;
				case 4: todoComplete(); break;
				case 5: todoUpdate(); break;
				case 6: todoDelete(); break;
				case 0: System.out.println("\n*** 프로그램 종료 ***\n"); break;
				default: System.out.println("\n### 메뉴에 작성된 번호만 입력해주세요 ###\n");
				}
			}catch(NumberFormatException e) {
				System.out.println("\n### 숫자만 입력해주세요 ###\n");
				input = -1; 
			}catch(IOException e) {
				System.out.println("\n### 입출력 관련 예외 발생 ###\n");
				e.printStackTrace(); 
			}catch(Exception e) { 
				e.printStackTrace();
			}
		}while(input != 0);
	}
	
	// --------------------------------------------------------------------------------------------
	
	private int selectMenu() throws NumberFormatException, IOException {
		System.out.println("\n============ Todo List ============\n");
		
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		System.out.println("\n============================================\n");
		
		System.out.print("select menu number >>> ");
		
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
	}
	
	// --------------------------------------------------------------------------------------------
	
	private void todoListFullView() {
		System.out.println("\n=============== [1. Todo List Full View] ===============\n");
		
		List<Todo> todoList = service.getTodoList();
		
		if(todoList.isEmpty()) {
			System.out.println("\n### Todo List가 존재하지 않습니다 ###\n");
			return;
		}
		
		int countComplete = service.countComplete();
		
		System.out.printf("\n[완료된 Todo 수 / 전체 Todo 수 : %d / %d]\n", countComplete, todoList.size());
		
		System.out.println("-------------------------------------------------------------------");
		System.out.println("인덱스           등록일             완료여부       할 일 제목");
		System.out.println("-------------------------------------------------------------------");
		
		for(int i=0; i<todoList.size(); i++) {
			String time = service.formattedDateTime(i);
			char complete = service.checkComplete(i);
			
			System.out.printf(" [%d]       %s         (%c)          %s\n", i, time, complete, todoList.get(i).getTitle());
		}
		
		System.out.println("=====================================================================\n");
	}
	
	// --------------------------------------------------------------------------------------------
	
	private void todoDetailView() throws NumberFormatException, IOException {
		System.out.println("\n=============== [2. Todo Detail View] ===============\n");

		System.out.print("인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		List<Todo> todoList = service.getTodoList();
		
		if(index < 0 || index >= todoList.size()) {
			System.out.println("\n### 입력한 인덱스 번호에 할 일(Todo)이 존재하지 않습니다 ###\n");
			return;
		}
		
		System.out.println("---------------------------------------------");
		System.out.println("제목 : " + todoList.get(index).getTitle());
		System.out.println("등록일 : " + service.formattedDateTime(index));
		System.out.println("완료 여부 : " + service.checkComplete(index));
		
		System.out.println("\n[세부내용]");
		System.out.println("---------------------------------------------");
		System.out.println(todoList.get(index).getDetail());
	}
	
	// --------------------------------------------------------------------------------------------
	
	private void todoAdd() throws IOException {
		System.out.println("\n=============== [3. Todo Add] ===============\n");
		
		System.out.print("할 일 제목 입력 : ");
		String title = br.readLine();
		
		System.out.println("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		System.out.println("-----------------------------------------------");
		
		List<Todo> todoList = service.getTodoList();
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			
			if(input.equals("!wq")) {
				System.out.printf("\n[%d] 인덱스에 추가되었습니다\n\n", todoList.size());
				break;
			}
			
			sb.append(input + "\n");
		}
		
		String detail = sb.toString();
		
		service.todoAdd(title, detail);
	}
	
	// --------------------------------------------------------------------------------------------

	private void todoComplete() throws NumberFormatException, IOException {
		System.out.println("\n=============== [4. Todo Complete] ===============\n");
		
		System.out.print("O <-> X 변경할 인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		List<Todo> todoList = service.getTodoList();
		
		if(index < 0 || index >= todoList.size()) {
			System.out.println("\n### 입력한 인덱스에 Todo가 존재하지 않습니다 ###\n");
			return;
		}
		
		service.todoComplete(index);
		
		System.out.println("\n[변경 되었습니다]\n");
	}
	
	// --------------------------------------------------------------------------------------------
	
	private void todoUpdate() throws NumberFormatException, IOException {
		System.out.println("\n=============== [5. Todo Update] ===============\n");
		
		System.out.print("수정할 Todo 인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		List<Todo> todoList = service.getTodoList();
		
		if(index < 0 || index >= todoList.size()) {
			System.out.println("\n### 입력한 인덱스에 Todo가 존재하지 않습니다 ###\n");
			return;
		}
		
		System.out.println("\n**************** [수정 전] ****************\n");
		
		System.out.println("---------------------------------------------");
		System.out.println("제목 : " + todoList.get(index).getTitle());
		System.out.println("등록일 : " + service.formattedDateTime(index));
		System.out.println("완료 여부 : " + service.checkComplete(index));
		
		System.out.println("\n[세부내용]");
		System.out.println("---------------------------------------------");
		System.out.println(todoList.get(index).getDetail());
		
		System.out.println("**********************************************\n");
		
		System.out.print("수정할 제목 : ");
		String title = br.readLine();
		
		System.out.println("수정할 세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		System.out.println("---------------------------------------------");
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			
			if(input.equals("!wq")) {
				System.out.println("\n[수정 되었습니다]\n");
				break;
			}
			
			sb.append(input + "\n");
		}
		
		String detail = sb.toString();
		
		service.todoUpdate(index, title, detail);
	}
	
	// --------------------------------------------------------------------------------------------
	
	private void todoDelete() throws NumberFormatException, IOException {
		System.out.println("\n=============== [6. Todo Delete] ===============\n");
		
		System.out.print("삭제할 인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		List<Todo> todoList = service.getTodoList();
		
		if(index < 0 || index >= todoList.size()) {
			System.out.println("\n### 입력한 인덱스에 Todo가 존재하지 않습니다 ###\n");
			return;
		}
		
		service.todoDelete(index);
		
		System.out.println("\n[삭제 되었습니다]\n");
	}
}
