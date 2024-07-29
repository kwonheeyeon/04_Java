package loop.ex;

import java.util.Scanner;

public class LoopEx1 {
	// 필드(전역 변수 비슷)
	Scanner sc = new Scanner(System.in);

	/**
	 * 1부터 10까지 출력하기
	 */
	public void method1() {
		// Java는 초기식 변수 선언 시 let X -> Java 자료형
		for(int i=1; i<=10; i++) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 첫 번째 입력 받은 수부터
	 * 두 번째 입력 받은 수 이하까지
	 * 세 번째 입력 받은 수 만큼 증가하며 출력하기
	 */
	public void method2() {
		System.out.print("시작 종료 증가값 : ");
		int start = sc.nextInt();
		int end = sc.nextInt();
		int increase = sc.nextInt();
		
		for(int i=start; i<=end; i+=increase) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 두 수를 입력 받아
	 * 작은 수 부터 큰 수 이하까지 1씩 증가하며 반복
	 */
	public void method3() {
		System.out.print("숫자 2개 입력 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a > b) {
			int temp = b;
			b = a;
			a = temp;
		}
		
		for(int i=a; i<=b; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\n--------------------------------");
		
		// 추가 변수를 이용해서 시작, 종료 값 지정하기
		int start = a;
		int end = b;
		
		if(a > b) { // 시작이 끝보다 큰 경우
			start = b;
			end = a;
		}
		
		for(int i=start; i<=end; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\n--------------------------------");
		
		// 자바에서 제공하는 기능(메서드) 이용
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		
		for(int i=min; i<=max; i++) {
			System.out.print(i + " ");
		}
	}
	
	/** 
	 * 1부터 100 사이의 정수 중 5의 배수의 합, 개수 구하기
	 * sum, count
	 */
	public void method4() {
		int sum = 0;
		int count = 0;
		
		for(int i=1; i<=100; i++) {
			if(i%5 == 0) {
				sum += i;
				count++;
			}
		}
		
		System.out.printf("1부터 100 사이의 정수 중 5의 배수의 합계 : %d, 개수 : %d\n", sum, count);
	}
	
	/**
	 * 구구단 3단 출력하기
	 */
	public void method5() {
		System.out.println("[3단]");
		
		for(int i=1; i<=9; i++) {
			System.out.printf("3 x %d = %d\n", i, 3*i);
		}
	}
	
	/**[구구단 출력하기 version.1]
	 * 입력 받은 단 출력하기
	 * 단, 입력 받은 단이 2~9 사이 숫자가 아니면
	 * "잘못 입력하셨습니다" 출력
	 */
	public void method6() {
		System.out.print("단 입력(2~9) : ");
		int dan = sc.nextInt();
		
		if(dan < 2 || dan > 9) {
			System.out.println("잘못 입력하셨습니다");
			return;
		}
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%d x %d = %d\n", dan, i, dan*i);
		}
	}
	
	/**
	 * while문 기본 작성법
	 */
	public void method7() {
		int num =   1 ;
		
		// while(조건식) -> 조건식이 true인 경우에 실행
		while(num <= 10) {
			System.out.print(num + " ");
			num++;
		}
	}
	
	// for(초기식; 조건식; 증감식)
	// -> 지정된 횟수만큼 반복
	
	// while(조건식)
	// -> 조건식이 false가 될 때까지 반복
	// 	  == 몇 회인지 모르겠지만 일단 끝날 때까지 반복
	
	/** [구구단 출력하기 version.2]
	 * 입력 받은 단 출력하기
	 * 단, 입력 받은 단이 2~9 사이 숫자가 아니면
	 * "잘못 입력하셨습니다" 출력 후
	 * 다시 단 입력 받기
	 */
	public void method8() {
		int dan;
		
		while(true) {
			System.out.print("단 입력(2~9) : ");
			dan = sc.nextInt();
		
			if(dan >= 2 && dan <= 9) {
				break;
			}
			
			System.out.println("잘못 입력하셨습니다");
		}
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%d x %d = %d\n", dan, i, dan*i);
		}
	}
}