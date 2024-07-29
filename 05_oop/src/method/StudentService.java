package method;

import java.util.Scanner;

// 기능 제공용 클래스
public class StudentService {
	// 필드
	private Scanner sc = new Scanner(System.in); // Scanner 객체 생성
	
	/**
	 * 메인 메뉴 화면
	 */
	public void mainMenu() {
		int input = 0; // 입력 받은 메뉴 번호를 저장할 변수
		
		// 생성될 학생 객체 주소를 저장할 참조 변수           
		// (null : 참조하는 객체가 없다, 주소 저장 X)
		Student std = null;
		
		// do ~ while : 최소 1회 이상 반복
		do {
			System.out.println("===== 학생 1명 관리 프로그램 =====");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 정보 확인");
			System.out.println("3. 학생 이름 수정");
			System.out.println("4. Java 공부하기");
			System.out.println("5. HTML 공부하기");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("==================================");
			System.out.print("메뉴 번호 입력 : ");
			input = sc.nextInt();
			
			sc.nextLine(); // 입력 버퍼에 남아있는 엔터 제거
			System.out.println();
			
			switch(input){
			case 1:
				std = registStudent();
				System.out.println("\n" + std.getName() + "학생 등록됨!!\n");
				break;
			case 2:	
				System.out.println("[학생 정보 확인]");
				
				System.out.println("학교 : " + Student.schoolName);
				// static은 클래스 명을 붙여서 호출!!
				
				System.out.println(std.toString());
				break;
			case 3:	
				// 학생 이름 수정 메서드 호출 시
				// std에 저장된 학생 객체 참조 주소를 전달(얕은 복사)
				updateName(std);
				break;
			case 4:	
				studyJava(std);
				break;
			case 5:	
				studyHtml(std);
				break;
			case 0:	System.out.println("* 프로그램을 종료합니다 *\n\n"); break;
			default: System.out.println("* 알맞은 메뉴 번호를 입력해주세요 *\n\n");
			}
		} while(input != 0); // 메뉴 번호 0 선택 시 반복 종료
	}
	
	/**
	 * 학생 등록 메서드
	 * @return 생성된 Student 객체의 주소 반환
	 */
	private Student registStudent() {
		System.out.println("[학생 등록]");
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학번 : ");
		String studentNumber = sc.nextLine();
		
		System.out.print("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		
		Student student = new Student(name, studentNumber, gender);
		
		// student 변수에는 생성된 Student 객체를 참조하는 주소 값이 저장되어있음
		// -> 주소 값을 반환 (== 주소 값이 복사되어 호출한 곳으로 돌아감)
		return student;
	}
	
	/**
	 * 학생 이름 수정 메서드
	 * @param std : 전달 받은 Student 객체 참조 주소
	 */
	private void updateName(Student std) {
		System.out.println("[학생 이름 수정]");
		System.out.println("기존 이름 : " + std.getName());
		
		System.out.print("변경할 이름 입력 : ");
		String newName = sc.nextLine();
		
		// 이름을 홍길동 -> 김철수로 변경하시겠습니까?
		System.out.printf("\n이름을 %s -> %s로 변경하시겠습니까?(y/n) ", std.getName(), newName);
		
		// String.toUpperCase() -> 대문자로 변환
		// String.toLowerCase() -> 소문자로 변환
		char check = sc.next().toLowerCase().charAt(0);
		
		if(check == 'n') {
			System.out.println("* 이름 변경 취소됨 *\n");
			return;
		} 
			
		// 새로운 이름을 std가 참조하는 객체에 세팅
		std.setName(newName);
		System.out.println("* 이름 변경 완료! *\n");
	}
	
	/**
	 * 자바 공부 수행 -> std의 자바 역량 증감
	 * 단, 수정된 자바 역량은 최대값(100), 최소값(0) 범위 초과가 불가능
	 */
	private void studyJava(Student std) {
		System.out.println("[Java 공부하기]");
		System.out.println("현재 자바 역량 점수 : " + std.getJava());
		int before = std.getJava(); // 이전 점수 저장
		
		System.out.print("증가 또는 감소한 Java 역량 점수 입력 : ");
		int score = sc.nextInt();
		
		// 기존 점수에 누적!!
		int temp = std.getJava() + score;
		
		if(temp > Student.MAX_VALUE) temp = Student.MAX_VALUE;
		else if(temp < Student.MIN_VALUE) temp = Student.MIN_VALUE;
			
		std.setJava(temp); // 참조하고 있는 학생 객체 java 필드에 대입
		
		System.out.println("\n* Java 역량 점수 수정 완료 *");
		
		// 기존 ->  변경 (증감)
		// 50 -> 80 (+30)
		// 50 -> 30 (-20)
		
		// 90 -> 100 (+30)
		// 10 -> 0 (-40)
		
		// 음수인 경우 score / 양수인 경우 +score
		String str = (score <= 0)? ("" + score) : ("+" + score); 
		System.out.printf("자바 역량 점수 : %d -> %d (%s)\n\n",before ,std.getJava(), str);
	}
	
	/**
	 * html 공부 수행 -> std의 html 역량 증감
	 */
	private void studyHtml(Student std) {
		System.out.println("[HTML 공부하기]");
		System.out.println("현재 HTML 역량 점수 : " + std.getHtml());
		int before = std.getHtml();
		
		System.out.println("증가 또는 감소한 HTML 역량 점수 입력 : ");
		int score = sc.nextInt();
		
		int temp = std.getHtml() + score;
		
		if(temp > Student.MAX_VALUE) temp = Student.MAX_VALUE;
		else if(temp < Student.MIN_VALUE) temp = Student.MIN_VALUE;
		
		std.setHtml(temp);

		System.out.println("\n* HTML 역량 점수 수정 완료 *");
		
		String str = (score <= 0)? ("" + score) : ("+" + score);
		System.out.printf("HTML 역량 점수 : %d -> %d (%s)\n\n", before, std.getHtml(), str);
	}
	
}
