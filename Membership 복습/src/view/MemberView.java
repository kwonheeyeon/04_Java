package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

public class MemberView {
	private MemberService service = null;
	private BufferedReader br = null;
	
	public MemberView() {
		try {
			service = new MemberServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in));
		}catch(Exception e){
			System.out.println("\n### 프로그램 실행 중 오류 방생 ###\n");
			e.printStackTrace();
			System.exit(0);
		}finally {
			
		}
	}
	
	public void mainMenu() {
		int input = 0;
		
		do {
			try {
				input = selectMenu();
				
				switch(input) {
				case 1: addMember(); break;
				case 2: selectAll(); break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: break;
				case 0: System.out.println("*** 프로그램 종료 ***"); break;
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
	
	private int selectMenu() throws NumberFormatException, IOException {
		System.out.println("\n============ 회원 관리 프로그램 ============\n");
		
		System.out.println("1. 회원 가입 (추가)");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 이름 검색(동명이인 있으면 모두 조회)");
		System.out.println("4. 특정 회원 사용 금액 누적");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("0. 종료");
		
		System.out.println("============================================\n");
		
		System.out.print("메뉴 선택 >>> ");
		
		int input = Integer.parseInt(br.readLine());
		
		return input;
	}
	
	private void addMember() throws IOException {
		System.out.println("\n*** 회원 가입 ***\n");
		
		System.out.print("이름 : ");
		String name = br.readLine();
		String phone = null;
		
		while(true) {
			System.out.print("휴대폰 번호 : ");
			phone = br.readLine();
			
			if(phone.length() != 11) {
				System.out.println("\n### 휴대폰 번호를 올바르게 입력해주세요 ###\n");
				continue;
			}
			
			break;
		}
		
		boolean result = service.addMember(name, phone);
		
		if(result == true) {
			System.out.println("\n*** 회원 추가가 완료되었습니다 ***\n");
		} else {
			System.out.println("\n### 중복된 회원(휴대폰번호)이(가) 존재합니다 ###\n");
		}
	}
	
	private void selectAll() {
		System.out.println("\n*** 회원 전체 조회 ***\n");
		
		List<Member> memberList = service.getMemberList();
		
		if(memberList.isEmpty()) {
			System.out.println("\n### 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		String[] gradeArr = {"일반", "골드", "다이아" };
		
		System.out.printf("%-6s %-8s %6s %6s \n", "[이름]", "[휴대폰 번호]", "[누적금액]", "[등급]");
		System.out.println("----------------------------------------\n");
		
		for(Member member : memberList) {
			System.out.printf("%-6s %-12s %7d %8s \n", member.getName(), member.getPhone(), member.getAmount(), gradeArr[member.getGrade()]);
		}
	}
}
