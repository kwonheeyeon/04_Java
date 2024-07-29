package run;

import dto.Parent;
import dto.Child1;

public class TestRun1 {
	public static void main(String[] args) {
		// 부모 객체 생성
		Parent p1 = new Parent(); // 기본 생성자
		Parent p2 = new Parent("서울시 강남구 역삼동", 300, "페라리"); // 매개 변수 생성자
 		
		System.out.println("--------------------------------------");

		// 자식 객체 생성
		Child1 c1 = new Child1();
		
		/* 자식이 부모 코드를 물려 받았는지 확인! */

		System.out.println(c1.inform()); // 부모 클래스의 private 필드를 간접적으로 접근 가능
		System.out.println("---------------------------------------");

		c1.setCar("테슬라 모델 X");
		System.out.println(c1.getCar());

		c1.setAddress("경기도 부천시");
		c1.setMoney(Integer.MAX_VALUE);

		System.out.println(c1.inform());

		System.out.println("--------------------------------------");

		System.out.println("[자식 매개 변수 생성자로 객체 생성]");
		Child1 c2 = new Child1("맥북 m3 프로");

		System.out.println(c2.inform() + " / " + c2.getNotebook());
				
		System.out.println("--------------------------------------");

		System.out.println("[protected 확인]");
		c2.print();

		System.out.println("--------------------------------------");

		System.out.println("[super 참조 변수 확인]");
		System.out.println(c2.childInform());
	}
}
