package practice;

import java.util.Scanner;

public class ArrayPractice {
	Scanner sc = new Scanner(System.in);
	
	/* [실습 문제 1]
	 * 
	 * 길이가 9인 배열을 선언 및 할당하고,
	 * 1부터 9까지의 값을 반복문을 이용하여
	 * 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
	 * 짝수 번째 인덱스 값의 합을 출력하세요.
	 * (0 번째 인덱스는 짝수로 취급)
	 */
	public void practice1() {
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			if(i % 2 == 0) sum += arr[i];
		}
		
		System.out.println();
		System.out.println("짝수 번째 인덱스 합 : " + sum);
	}
	
	/* [실습 문제 2]
	 * 
	 * 길이가 9인 배열을 선언 및 할당하고,
	 * 9부터 1까지의 값을 반복문을 이용하여
	 * 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
	 * 홀수 번째 인덱스 값의 합을 출력하세요.
	 * (0 번째 인덱스는 짝수로 취급)
	 */
	public void practice2() {
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr.length-i;
			System.out.print(arr[i] + " ");
			if(i % 2 == 1) sum += arr[i];
		}
		
		System.out.println();
		System.out.println("홀수 번째 인덱스 합 : " + sum);
		
		System.out.println("-------------------------------------------");
		
		// 역방향(8 -> 0)
		int[] arr2 = new int[9];
		
		int sum2 = 0;
		
		// arr.length     : 9 9 9 9 9 9 9 9 9
		// i              : 8 7 6 5 4 3 2 1 0
		// arr.length - i : 1 2 3 4 5 6 7 8 9
		// arr[i]         : 1 2 3 4 5 6 7 8 9
		
		// 대입은 역방향
		for(int i = arr2.length - 1 ; i >= 0 ; i--) {
			arr2[i] = arr2.length - i;
			
			if(i % 2 == 1) sum2 += arr2[i];
		}
		
		// 출력은 정방향
		for(int num : arr2) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		System.out.println("홀수 번째 인덱스 합 : " + sum);
	}
	
	/* [실습 문제 3]
	 * 
	 * 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
	 * 1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
	 */
	public void practice3() {
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}
	}
	
	/* [실습 문제 4]
	 * 
	 * 정수 5개를 입력 받아 배열을 초기화 하고
	 * 검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
	 * 배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
	 */
	public void practice4() {
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}
		
		System.out.println("검색할 값 : ");
		int search = sc.nextInt();
		
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == search) {
				System.out.println("인덱스 : " + i);
				return;
			}
		}
		
		System.out.println("일치하는 값이 존재하지 않습니다.");
	}
	
	/* [실습 문제 5]
	 * 
	 * 사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
	 * 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
	 * 그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
	 */
	public void practice5() {
		System.out.print("정수 : ");
		int length = sc.nextInt();
		int[] arr = new int[length];
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		System.out.println("총합 : " + sum);
	}
	
	/* [실습 문제 6]
	 * 
	 * 주민등록번호를 입력 받아 char 배열에 저장한 후 출력하세요.
	 * 단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
	 */
	public void practice6() {
		System.out.print("주민등록번호(-포함) : ");
		String resNum = sc.next();
		char[] arr = new char[14];
		
		for(int i=0; i<arr.length; i++) {
			if(i < 8)
				arr[i] = resNum.charAt(i);
			else
				arr[i] = '*';
			
			System.out.print(arr[i]);
		}
	}
	
	/* [실습 문제 7]
	 * 
	 * 3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
	 * 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
	 * 단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
	 * 다시 정수를 받도록 하세요.
	 */
	public void practice7() {
		int check;
		int length;
		
		do {
			check = 1;
			System.out.print("정수 : ");
			length = sc.nextInt();
			
			if(length < 3 || length % 2 == 0) {
				System.out.println("다시 입력하세요.");
				check = 0;
			}
		} while(check == 0);
		
		int[] arr = new int[length];
		
		for(int i=1; i<(arr.length/2)+2; i++) {
			arr[i] = i;
			System.out.print(arr[i] + " ");
		}
		
		for(int i=(arr.length/2) ; i >0; i--) {
			arr[i] = i;
			System.out.print(arr[i] + " ");
		}
	}
	
	/* [실습 문제 8]
	 * 
	 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
	 * 1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
	 */
	public void practice8() {
		int[] arr = new int[10];
		
		System.out.print("발생한 난수 : ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			System.out.print(arr[i] + " ");
		}
	}
	
	/* [실습 문제 9]
	 * 
	 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
	 * 1~10 사이의 난수를 발생시켜 배열에 초기화 후
	 * 배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
	 */
	public void practice9() {
		int[] arr = new int[10];
		
		System.out.print("발생한 난수 : ");
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			System.out.print(arr[i] + " ");
		}
		
		int max = arr[0];
		int min = arr[0];
		
		for(int num : arr) {
			if(max < num) max = num;
			if(min > num) min = num;
		}
		
		System.out.println();
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
	
	/* [실습 문제 10]
	 * 
	 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
	 * 1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
	 */
	public void practice10() {
		int[] arr = new int[10];
		
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			
			for(int j=0; j<i; j++) {
				if(arr[j] == arr[i])
					i--;
			}
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
	}
	
	/* [실습 문제 11]
	 * 
	 * 로또 번호 자동 생성기 프로그램을 만들기.
	 * (중복 값 없이 오름차순으로 정렬하여 출력하세요.)
	 */
	public void practice11() {
		int[] arr = new int[6];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*45+1);
			
			for(int j=0; j<i; j++) {
				if(arr[j] == arr[i])
					i--;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				int temp;
				
				if(arr[i] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
	}
	
	/* [실습 문제 12]
	 * 
	 * 문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
	 * 문자의 개수와 함께 출력하세요. (중복 제거)
	 */
	public void practice12() {
		System.out.print("문자열 : ");
		String str = sc.next();
		char[] arr = new char[str.length()];
		int count = 0;
		
		for(int i=0; i< arr.length; i++) {
			arr[i] = str.charAt(i);
			
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j])
					arr[i] = ' ';
			}
		}
		
		System.out.print("문자열에 있는 문자 : ");
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != ' ') {
				System.out.print(arr[i] + " ");
				count++;
			}
		}
		
		System.out.println();
		System.out.println("문자 개수 : " + count);
	}
	
	/* [실습 문제 13]
	 * 
	 * 사용자가 입력한 배열의 길이만큼의 String 배열을 선언 및 할당하고
	 * 배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
	 * 단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지,
	 * 늘린 곳에 어떤 데이터를 넣을 것인지 받으세요.
	 * 사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요.
	 * (배열의 얕은 복사, 깊은 복사를 이용하는 문제)
	 */
	public void practice13() {
		System.out.print("배열의 크기를 입력하세요 : ");
		int length = sc.nextInt();
		String[] arr = new String[length];
		String[] copyArr= arr;
		
		int index;
		
		for(index=0; index<arr.length; index++) {
			System.out.printf("%d번째 문자열 : ", index);
			arr[index] = sc.next();
		}
		
		boolean flag = false;
		
		do {
			System.out.print("더 값을 입력하시겠습니까?(Y/N)");
			String str = sc.next();
			
			if(str.charAt(0)== 'Y'|| str.charAt(0)== 'y') {
				
				flag = true;
				System.out.print("더 입력하고 싶은 개수 : ");
				int num = sc.nextInt();
				
				if(num < 0) {
					System.out.println("잘못 입력하셨습니다");
					continue;
				}
				
				for(int i = 0; i<num; i++) {
					System.out.printf("%d 번째 문자열 : ", index);
					copyArr[index] = sc.next();
					index++;
				}
				
			} else if(str.charAt(0)== 'N'|| str.charAt(0)== 'n') {
				flag = false;
			} else {
				System.out.println("잘못 입력하셨습니다");
				flag = true;
			}
			
		}while(flag == true);
		
		String[] resultArr = new String[copyArr.length];
		for(int i=0; i<copyArr.length; i++) {
			resultArr[i] = copyArr[i];
			System.out.println(resultArr[i]);
		}
		
		
	}
}

//for(String s : copyArr) {
//	System.out.println(s);
//}









