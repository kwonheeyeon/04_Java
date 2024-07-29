package dto;

/* 상속 : 부모의 코드(필드/메서드)를 물려 받아
 * 	  자식이 자신의 코드인 것처럼 사용
 *
 * 	  -> 물려받은 부모의 필드/메서드가
 *	     정말로 자식의 것이 되는 것이 아닌
 *	     자식 객체 생성 시 부모 객체가 같이 생성되어
 *	     두 객체가 합쳐진 모양을 띄게 된다!!!
 * 
 * 상속 키워드 : extends(확장하다)
 *   -> 부모 코드를 물려 받은 자식의 크기가 커지기 때문에!
 * 
 * ** 주의 사항 **
 * - 부모의 코드 중 생성자는 물려받지 못함!
 *
 * - 부모의 private 접근 제한자 필드/메서드는
 *   상속 받긴 하지만 직접 접근 불가!!!
 *   -> 상속 관계여도 다른 클래스(객체)로 인식 되기 때문에 접근 불가
 */

public class Child1 extends Parent {
	// 필드

	private String notebook;
	
	/* super() 생성자 
	 * - super 뜻 : 상위의, 위쪽의
	 *
	 * - 현재 클래스의 상위객체(부모) 생성자를 호출하는 구문
	 *
	 * - super()는 자식 생성자에만 작성할 수 있으며
	 *   반드시 첫 번째 줄에 작성해야 한다!!!
	 */

	// 기본 생성자
	public Child1() {
		super();		

		System.out.println("자식1 - 기본 생성자로 객체 생성");
	}

	// 매개 변수 생성자
	public Child1(String notebook) {
		// 부모 매개 변수 생성자 호출하기
		super("부산 해운대구", 123456789, "모하비");

		this.notebook = notebook;
		System.out.println("자식1 - 매개 변수 생성자로 객체 생성");
	}

	// getter / setter
	public String getNotebook() {
		return notebook;
	}

	public void setNotebook(String notebook) {
		this.notebook = notebook;
	}
	
	/** 
	 *자식 객체 + 부모 객체에 있는 모든 필드 값 출력
	 */
	public void print() {
		// 부모 필드
		
		// protected 필드 : 상속 받은 클래스에서 직접 접근 가능!!
		System.out.println("lastName : " + lastName);

		// private 필드 : 간접 접근
		System.out.println("address : " + getAddress());
		System.out.println("money : " + getMoney());
		System.out.println("car : " + getCar());

		// 자식 필드
		System.out.println("notebook : " + notebook);
	}
	
	/* super 참조 변수
	 * - 자식 객체 내부의 부모 객체를 참조하는 변수
	 *
	 * - 언제 사용해???
	 *  -> 부모의 필드/메서드 임을 확실하게 명시할 때 주로 사용
	 */

	/** 자식 + 부모 필드 정보를 하나의 문자열로 반환
	 * -> 성 / 주소 / 돈 / 차 / 노트북
	 */
	public String childInform() {
		// return String.format("%s / %s / %d / %s / %s", lastName, getAddress(), getMoney(), getCar(), notebook);

		return super.inform() + " / " + notebook;		
	}

	/* 오버라이딩(Overriding) : 덮어 쓰기 / 재정의
	 * Over : 위에 있다, 넘어서다 
	 * Riding : 타는 것
	 *
	 * - 부모로부터 물려 받은 메서드를
	 *   자식이 같은 이름의 메서드를 정의해서 덮어쓰기 
	 *    -> 물려 받은 자식에 맞게
	 *       부모의 메서드를 다시 정의해야되는 경우 사용
	 *
	 * ** 중요 **
	 *
	 * @Override 어노테이션(Annotation)
	 * 1) 해당 메서드는 오버라이딩 되었음을 명시
	 *
	 * 2) 오버라이딩된 코드가 알맞게 작성되었는지
	 *    컴파일러에게 검사하라고 지시하는
	 *    컴파일러 주석
	 *
	 * [오버라이딩 성립 조건]
	 * 1. 접근 제한자는 부모와 같거나 더 넓은 범위
	 * 2. 반환형, 매개 변수, 메서드명은 모두 동일
	 * 3. 예외처리 구문(throw)은 같거나 좁은 범위
	 *
	 * (쉽게 말해서 부모랑 똑같이 쓰는게 제일 쉬움) 
	 */
	
	// 컴파일러야 이거 잘 쓴건지 검사해줘
	@Override
	public void introduce() {
		System.out.println("저는 Parent의 자식 Child1입니다");
	}
	
	// Parent에게 상속 받은 toString() 오버라이딩
	@Override
	public String toString() {
		// Child1 클래스 내부에서 toString() 호출하면
		// Child1.toString()이 호출됨

		// super.toString() : 부모 클래스에 작성된 toString() 호출
		// -> 오버라이딩 했다고 해서
		//    부모의 메서드가 덮어쓰기되어 사라지는 것이 아니다!!

		return super.toString() + " / " + notebook;
	}

	// final 메서드 확인하기 -> 오버라이딩 시도
	// @Override	
	// public final void onlyParent(){}
	// Cannot override the final method from Parent
	// -> 오버라이딩 불가 에러
}
