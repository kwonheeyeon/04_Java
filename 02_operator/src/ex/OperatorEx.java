package ex;

import java.util.Scanner;

/**
 * 연산자 예제 기능용 클래스
 */
public class OperatorEx {
	// OperatorRun에서
	// 호출할 수 기능을 정의해두는 클래스
	
	// method == 객체(클래스)가 가지고 있는 기능(function)
	
	// text1() 메서드
	public void test1() {
		System.out.println("test1() 메서드 호출됨");
	}
	
	public void test2() {
		System.out.println("22222222222222222222");
	}
	
	/**
	 * 입력 받은 두 정수의 산술 연살 결과 출력하기
	 * 
	 * 정수 입력 1 : 10
	 * 정수 입력 2 : 3
	 * 
	 * 10 + 3 = 13
	 * 10 - 3 = 7
	 * 10 * 3 = 30
	 * 10 / 3 = 3
	 * 10 % 3 = 1
	 */
	public void method1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt(); // 입력 버퍼에 있는 다음 정수 읽어오기
								 // -> 정수만 읽어오고 [엔터]는 남음!!
		
		System.out.print("정수 입력 2 : ");
		int num2 = sc.nextInt();
		
		System.out.println(); // 줄 바꿈
		
		// \n : 개행(escape) 문자
		System.out.printf("%d + %d = %d \n", num1, num2, num1 + num2);
		System.out.printf("%d - %d = %d \n", num1, num2, num1 - num2);
		System.out.printf("%d * %d = %d \n", num1, num2, num1 * num2);
		System.out.printf("%d / %d = %d \n", num1, num2, num1 / num2);
		System.out.printf("%d %% %d = %d \n", num1, num2, num1 % num2);
		// printf에서 %% == '%'
	}
	
	/**
	 * 입력 받은 정수가 3의 배수가 맞는지 확인
	 */
	public void method2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// input이 3의 배수가 맞으면 true, 아니면 false 저장
		boolean isTrue = (input % 3 == 0);
		
		System.out.printf("%d 는 3의 배수인가? %b", input, isTrue);
	}
	
	/**
	 * 첫 번째 입력 받은 수가
	 * 두 번째 입력 받은 수의 배수가 맞는지 확인
	 * 
	 * [true인 경우]
	 * 첫 번째 입력 : 20
	 * 두 번째 입력 : 5
	 * 
	 * 20은 5의 배수가 맞는가? true
	 * 
	 * [false인 경우]
	 * 첫 번째 입력 : 9
	 * 두 번째 입력 : 4
	 * 
	 * 9는 4의 배수가 맞는가? false
	 */
	public void method3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 입력 : ");
		int input1 = sc.nextInt();
		
		System.out.print("두 번째 입력 : ");
		int input2 = sc.nextInt();
		
		System.out.printf("%d은(는) %d의 배수가 맞는가? %b", input1, input2, (input1%input2 == 0));
	}
	
	/**
	 * 생성된 난수가 1 이상 10 이하 짝수가 맞는지 확인
	 * (난수 범위 1 ~ 20)
	 */
	public void method4() {
		// 1 ~ 20 사이 난수
		int randomNumber = (int)(Math.random()*20 + 1);
		System.out.println("생성된 난수 : " + randomNumber);
		
		// 1 이상 10 이하가 맞는지 확인
		boolean result1 = 1 <= randomNumber && randomNumber <= 10;
		
		// 짝수 확인
		boolean result2 = randomNumber % 2 == 0;
		
		System.out.println("1 ~ 10 사이 짝수 맞아?" + (result1 && result2));
	}
	
	/**
	 * 입력받은 수가 짝수이거나
	 * 10보다 큰 수 (초과) 인지 확인
	 */
	public void method5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		boolean result = (input % 2 == 0) || (input > 10);
		
		System.out.println("입력 받은 수가 짝수이거나 10보다 큰 수 인가? " + result);
	}
	
	/** [삼항 연산자 1]
	 * 1 ~ 10 사이 난수를 발생시켜 홀/짝 검사
	 */
	public void method6() {
		// 1 ~ 10 사이 난수
		int ran = (int)(Math.random()*10 + 1);
		String result = ran % 2 == 0 ? "짝수" : "홀수";
		System.out.printf("%d은(는) %s", ran, result);
	}
	
	/** [삼항 연산자 2]
	 * 
	 * 나이를 입력 받아
	 * 13세 이하 "어린이"
	 * 14세 이상 19세 이하 "청소년"
	 * 20세 이상 "성인"
	 * 
	 * 구분하여 출력하기
	 */
	public void method7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result = age <= 13 ? "어린이" : ( age <= 19 ? "청소년" : "성인" );
		System.out.println(result);
	}
}