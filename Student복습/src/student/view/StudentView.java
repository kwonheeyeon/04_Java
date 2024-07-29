package student.view;

import java.util.Scanner;

import student.dto.StudentDTO;
import student.service.StudentService;

public class StudentView {
	StudentService service = new StudentService();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		int input = 0;
		
		do {
			System.out.println("\n=========== 학생 관리 프로그램 ===========");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회"); // 동명이인 X
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			System.out.println("==========================================");
			
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch(input) {
			case 1: 
				addStudent();
				break;
			case 2: 
				selectAll();
				break;
			case 3: 
				selectIndex();
				break;
			case 4:
				selectTargetName();
				break;
			case 5: break;
			case 6: break;
			case 7: break;
			
			case 0: System.out.println("*** 프로그램 종료 ***"); break;
			default: System.out.println("*** 메뉴 선택 오류 ***");
			}
		} while(input != 0);
	}
	
	public void addStudent() {
		System.out.println("----- 학생 추가 -----");
		
		System.out.print("학번 : ");
		String studentNumber = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.println("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		
		System.out.println();
		
		StudentDTO std = new StudentDTO(name, studentNumber, gender);
		boolean check = service.addStudent(std);
		
		if(check == false) {
			System.out.println("더 이상 학생을 추가할 수 없습니다.");
		}
		
		System.out.println(name + " 학생이 추가되었습니다");
	}
	
	public void selectAll() {
		System.out.println("----- 학생 전체 조회 -----\n");
		
		StudentDTO[] stds = service.selectAll();
		
		for(StudentDTO std : stds) {
			if(std == null) break;
			
			System.out.println(std.toString());
		}
	}
	
	public void selectIndex() {
		System.out.println("----- 학생 1명 조회(index) -----\n");
		
		System.out.println("조회할 학생의 인덱스 입력 : ");
		int index = sc.nextInt();
		
		StudentDTO std = service.selectIndex(index);
		
		if(std == null) {
			System.out.println("\n" + index + "번째의 학생이 존재하지 않습니다");
			return;
		}
		
		System.out.println("\n----- " + index + "번째의 학생 정보 -----\n");
		System.out.println(std.toString());
	}
	
	public void selectTargetName() {
		System.out.println("----- 학생 1명 조회(이름) -----\n");
		
		System.out.println("조회할 학생의 이름 입력 : ");
		String targetName = sc.nextLine();
		
		StudentDTO std = service.selectTargetName(targetName);
		
		if(std == null) {
			System.out.println("\n" + targetName + " 학생이 존재하지 않습니다");
			return;
		}
		
		System.out.println("\n----- " + targetName + " 학생 정보 -----\n");
		System.out.println(std.toString());
	}
}
