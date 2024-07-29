package method;

// class : 객체(속성(필드), 기능(메서드))를 정의하는 문서 (== 설계도)
public class Student {
	/* 필드(== 멤버 변수) */
	
	// 필드 1 - class 변수(== static 변수)
	// -> 클래스명.변수명 형태로 호출하기 때문에 class 변수
	
	public static String schoolName = "KH대학교";
	
	public static final int MIN_VALUE = 0; // 스킬 역량 최소값
	public static final int MAX_VALUE = 100; // 스킬 역량 최대값
	// final : 상수 -> 대문자로 작성
	
	// 필드 2 - instance 변수
	// 캡슐화 원칙 -> private
	// -> new 연산자에 의해서 생성된 객체(instance) 변수
	// -> 객체가 생성될 때 heap영역에 같이 생성
	
	private String name;			// 이름
	private String studentNumber;	// 학번
	private char gender;			// 성별
	private int java;				// 자바 역량 점수
	private int html;				// html 역량 점수
	
	/* 생성자 */
	
	// new 연산자에 의해 객체 생성 시 실행되는 메서드(기능)
	// 반환형 X / 클래스명과 동일해야함
	
	public Student() {} // 기본 생성자
	
	// (오버 로딩 적용)
	// 매개 변수 생성자
	public Student(String name, String studentNumber, char gender) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.gender = gender;
	}
	
	/* 메서드 */
	
	// getter/setter
	// -> 자동완성 : alt + shift + s -> r
	
		   // 반환형 : 메서드 호출 시 반환되는 값의 자료형
	public String getName() {
		return name;
	}
	
		   // 반환형 void : return 옆에 반환할 값이 없다
		   // return; -> 미작성 시 컴파일러가 자동 추가
						// 매개 변수 : 메서드 호출 시 전달된 값을 저장하는 변수
	public void setName(String name) {
		this.name = name;
		// this 참조 변수 : 생성된 객체 자체를 참조하는 변수(이 객체!)
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentNumver(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public int getJava() {
		return java;
	}
	
	public void setJava(int java) {
		this.java =java;
	}
	
	public int getHtml() {
		return html;
	}
	
	public void setHtml(int html) {
		this.html = html;
	}
	
	// 객체의 필드 값을 문자열로 반환하는 메서드
	public String toString() {
		// 240001 / 홍길동 / 남 / java : 80 / html : 70
		
		// String String.format("패턴", 값);
		// -> 패턴 형태의 문자열을 반환하는 메서드
		// (printf와 비슷한데 printf는 출력, String.format()은 문자열 만들어서 반환)
		
		return String.format("%s / %s / %c / java : %d / html : %d\n", studentNumber, name, gender, java, html);
	}
}
