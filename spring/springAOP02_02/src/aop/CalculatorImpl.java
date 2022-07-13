package aop;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int x, int y) {	
		int result=x+y;
		return result;
	}

	@Override
	public int sub(int x, int y) {
		int result=x-y;	
		return result;
	}

	@Override
	public int mult(int x, int y) {
		int result=x*y;
		return result;
	}

	@Override
	public int div(int x, int y) {
		int result=x/y;
		return result;
	}

}
