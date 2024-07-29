package pkg3.dto;

// 인터페이스 상속 키워드 : implements (구현하다)

public class LKWCalculator implements Calculator{

	@Override
	public int plus(int a, int b) {
		int result = a + b;
		
		if(result > MAX_NUM) {
			return MAX_NUM;
		} else if (result < MIN_NUM) {
			return MIN_NUM;
		}
		
		return result;
	}

	@Override
	public int minus(int a, int b) {
		int result = a - b;
		
        if (result > MAX_NUM) {
            return MAX_NUM;
        } else if (result < MIN_NUM) {
            return MIN_NUM;
        }
        
		return result;
	}

	@Override
	public int multi(int a, int b) {
		int result = a * b;
		
        if (result > MAX_NUM) {
            return MAX_NUM;
        } else if (result < MIN_NUM) {
            return MIN_NUM;
        }
		
		return result;
	}

	@Override
	public int div(int a, int b) {
		int result = a / b;
		
        if (result > MAX_NUM) {
            return MAX_NUM;
        } else if (result < MIN_NUM) {
            return MIN_NUM;
        }
		
		return result;
	}

	@Override
	public int mod(int a, int b) {
		int result = a % b;
		
        if (result > MAX_NUM) {
            return MAX_NUM;
        } else if (result < MIN_NUM) {
            return MIN_NUM;
        }
		
		return result;
	}

	@Override
	public int pow(int a, int x) {
		int result = 1;
		
        for (int i = 0; i < x; i++) {
            result *= a;
            if (result > MAX_NUM) {
                return MAX_NUM;
            } else if (result < MIN_NUM) {
                return MIN_NUM;
            }
        }
        
		return result;
	}

	@Override
	public double areaOfCircle(double r) {

	    return Math.PI * r * r;
	}

	@Override
	public String toBinary(int num) {
		
        return Integer.toBinaryString(num);
	}

	@Override
	public String toHexadecimal(int num) {
		
        return Integer.toHexString(num);
	}

}
