package pkg3.dto;

// 인터페이스 상속 키워드 : implements (구현하다)

public class JIJCalculator implements Calculator{

	@Override
	public int plus(int a, int b) {
		int result = a + b;
		
		if (result > MAX_NUM) return MAX_NUM;
		if (result < MIN_NUM) return MIN_NUM;
		
		return result;
	}

	@Override
	public int minus(int a, int b) {
		int result = a - b;
		
		if (result > MAX_NUM) return MAX_NUM;
		if (result < MIN_NUM) return MIN_NUM;
		
		return result;
	}

	@Override
	public int multi(int a, int b) {
		int result = a * b;
		
		if (result > MAX_NUM) return MAX_NUM;
		if (result < MIN_NUM) return MIN_NUM;
		
		return result;
	}

	@Override
	public int div(int a, int b) {
		int result = a / b;
		
		if (result > MAX_NUM) return MAX_NUM;
		if (result < MIN_NUM) return MIN_NUM;
		
		return result;
	}

	@Override
	public int mod(int a, int b) {
		int result = a % b;
		
		if (result > MAX_NUM) return MAX_NUM;
		if (result < MIN_NUM) return MIN_NUM;
		
		return result;
	}

	@Override
	public int pow(int a, int x) {
		int result = (int) Math.pow(a, x);
		
		if (result > MAX_NUM) return MAX_NUM;
		if (result < MIN_NUM) return MIN_NUM;
		
		return result;
	}

	@Override
	public double areaOfCircle(double r) {
		double result = PI * r * r;
		
		if (result > MAX_NUM) return MAX_NUM;
		if (result < MIN_NUM) return MIN_NUM;
		
		return result;
	}

	@Override
	public String toBinary(int num) {

		if (num > MAX_NUM) Integer.toBinaryString(MAX_NUM);
		if (num < MIN_NUM) Integer.toBinaryString(MIN_NUM);
		return Integer.toBinaryString(num);
	}

	@Override
	public String toHexadecimal(int num) {
		if (num > MAX_NUM) Integer.toHexString(MAX_NUM);
		if (num < MIN_NUM) Integer.toHexString(MIN_NUM);
		return Integer.toHexString(num);
	}

}
