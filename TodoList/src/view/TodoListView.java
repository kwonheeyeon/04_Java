package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
				// 메뉴 출력 후 입력된 번호를 반환 받기
				input = selectMenu();
				
				// 선택된 메뉴 번호에 따라 case 선택
				switch(input) {
				case 1: todoListFullView(); break;
				case 2: ; break;
				case 3: todoAdd(); break;
				case 4: ; break;
				case 5: ; break;
				case 6: ; break;
				case 0: System.out.println("\n*** 프로그램 종료 ***\n"); break;
				default: System.out.println("\n### 메뉴에 작성된 번호만 입력해주세요 ###\n");
				}
				
				System.out.println("\n============================================\n");
				
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
		System.out.println("\n============ [1. Todo List Full View] ============\n");
		
		List<Todo> todoList = service.getTodoList();
		
		if(todoList.isEmpty()) {
			System.out.println("\n### Todo List가 존재하지 않습니다 ###\n");
			return;
		}
	}
	
	// --------------------------------------------------------------------------------------------
	
	private void todoAdd() throws IOException {
		System.out.println("\n============ [3. Todo Add] ============\n");
		
		List<Todo> todoList = service.getTodoList();
		
		System.out.print("할 일 제목 입력 : ");
		String title = br.readLine();
		
		System.out.println("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		System.out.println("-----------------------------------------------");
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
	
			sb.append(br.readLine());
			System.out.println(sb.toString());
			
			if(sb.equals("!wq")) {
				System.out.printf("[%d] 인덱스에 추가되었습니다", todoList.size()-1);
				break;
			}
		}
		
		String detail = sb.toString();
		
		service.todoAdd(title, detail);
	}
}















