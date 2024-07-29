package loop.ex;

import java.util.Scanner;

public class LoopEx2 {
	Scanner sc = new Scanner(System.in);
	
	/**다음 모양 출력하기
	 * 1234
	 * 1234
	 * 1234
	 */
	public void method1() {
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=4; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	/**다음 모양 출력하기
	 * 54321
	 * 54321
	 * 54321
	 * 54321
	 */
	public void method2() {
		for(int i=1; i<=4; i++) {
			for(int j=5; j>=1; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	/**
	 * 행, 열, 정방향(1)/역방향(-1) 입력 받아 출력
	 * 
	 * 행 입력 : 3
	 * 열 입력 : 6
	 * 정방향(1) / 역방향(-1) : -1
	 * 
	 * 654321
	 * 654321
	 * 654321
	 */
	public void method3() {
		System.out.print("행 입력 : ");
		int row = sc.nextInt();
		
		System.out.print("열 입력 : ");
		int col = sc.nextInt();
		
		System.out.print("정방향(1) / 역방향(-1) : ");
		int dir = sc.nextInt();
		
		if(row < 0 || col < 0 || (dir != 1 && dir != -1)) {
			System.out.println("잘못 입력하셨습니다");
			return;
		}
			
		if(dir == 1) {
			for(int i=1; i<=row; i++) {
				for(int j=1; j<=col; j++) {
					System.out.print(j);
				}
				System.out.println();
			}
		}else {
			for(int i=1; i<=row; i++) {
				for(int j=col; j>=1; j--) {
					System.out.print(j);
				}
				System.out.println();
			}
		}
		
		System.out.println("===================================");
		
		/* 2 */
		for(int x = 1 ; x <= row ; x++) { // 행
			
			if(dir == 1) {
				for(int y = 1 ; y <= col ; y++) {
					System.out.print(y); // 정방향
				}
			} else {
				for(int y = col ; y >= 1 ; y--) {
					System.out.print(y); // 역방향
				}
			}
			
			System.out.println(); // 행 출력 완료 -> 줄 바꿈
		}
		
		System.out.println("===================================");
		
		/* 3 */
		int start = 1;
		int end = col;
		
		if(dir == -1) {
			start = col;
			end = 1;
		}
		
		for(int i=1; i<=row; i++) {
			for(int j=start; ; j+=dir) {
				if(dir == 1 && j <= end) {
					System.out.print(j);
					continue;
				}
				
				if(dir == -1 && j >= end) {
					System.out.print(j);
					continue;
				}
				System.out.println();
				break;
			}
		}
	}
	
	/**다음 모양 출력하기
	 * 
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) (1,2)
	 * (2,0) (2,1) (2,2)
	 * 
	 */
	public void method4() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.printf("(%d,%d) ", i, j);
			}
			System.out.println();
		}
	}
	
	/**다음 모양 출력하기
	 * 
	 * (0,0) 
	 * (1,0) (1,1) 
	 * (2,0) (2,1) (2,2)
	 */
	public void method5() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<=i; j++) {
				System.out.printf("(%d,%d) ", i, j);
			}
			System.out.println();
		}
	}
	
	/**
	 * /** 다음 모양 출력 하기
	 * 
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) 
	 * (2,0) 
	 */
	public void method6() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3-i; j++) {
				System.out.printf("(%d,%d) ", i, j);
			}
			System.out.println();
		}
	}
	
	/**[do ~ while]
	 * - 최소 1회 이상 반복하는 while문
	 */
	public void method7() {
		int num = 10;
		
		do {
			System.out.println("반복 출력");
		} while(num < 10);
		
		System.out.println("---종료---");
	}
	
	/**
	 * 0이 입력될 때까지 입력된 모든 수의 합
	 */
	public void method8() {
		int input = 0;
		int sum = 0;
		
		do {
			System.out.print("숫자 입력(0은 종료) : ");
			input = sc.nextInt();
			sum += input;
		} while(input != 0);
		
		System.out.println("합계 : " + sum);
	}
}