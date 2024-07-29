package basic;

public class AccountRun {
	public static void main(String[] args) {
		// Account 객체 생성
		Account a1 = new Account();
		
		// The field Account.accountNumber is not visible
		// -> 캡슐화(private)로 인해 변수가 보이지 않아서 오류
		
//		a1.name = "홍길동";
//		a1.accountNumber = "1234567890";
//		a1.balance = 10000;
//		a1.password = "1q2w3e4";
//		
		// a1 계좌의 잔액, 비밀번호 바꾸기
//		System.out.println("a1 잔액 : " + a1.balance);
//		
//		a1.balance = 0;
//		a1.password = "asdf1234";
		
		// 간접 접근 기능을 이용해 세팅
		a1.setName("홍길동");
		a1.setAccountNumber("1234567890");
		a1.setBalance(10000);
		a1.setPassword("1q2w3e4");
		
		// 간접 접근 기능을 이용해 값 얻어오기
		System.out.println("[값 얻어오기]");
		String name1 = a1.getName();
		String accountNumber1 = a1.getAccountNumber();
		long balance1 = a1.getBalance();
		String password1 = a1.getPassword();
		
		System.out.printf("%s / %s / %d / %s \n", name1, accountNumber1, balance1, password1);
		
		System.out.println("--------------------------------------------------");
		System.out.println("[입금 기능]");
		a1.deposit(5000); // a1이 참조하는 계좌의 잔액을 5000원 추가
		
		System.out.println("--------------------------------------------------");
		System.out.println("[참조형 변수 비교]");
		
		String a = "ABCD";
		String b = new String("ABCD");
		
		System.out.println(a); // ABCD
		System.out.println(b); // ABCD
		System.out.println(a==b); // false (동일비교)
		System.out.println(a.equals(b)); // true (동등비교)
		
		System.out.println("--------------------------------------------------");
		System.out.println("[출금 기능]");
		
		a1.withdraw("asdf789", 2000000); // 비밀번호 불일치
		a1.withdraw("1q2w3e4", 2000000); // 잔액 부족
		a1.withdraw("1q2w3e4", 7000); // 출금 성공
		a1.withdraw("1q2w3e4", 8000); // 모두 출금
	}
}






