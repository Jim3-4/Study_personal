package aop;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int x, int y) {	
		long start=System.nanoTime();
		int result=x+y;
		long end=System.nanoTime();
		System.out.printf("처리시간 :%dns\n",(end-start));
		return result;
	}

	@Override
	public int sub(int x, int y) {
		long start=System.nanoTime();
		int result=x-y;
		long end=System.nanoTime();
		System.out.printf("처리시간 :%dns\n",(end-start));
		return result;
	}

	@Override
	public int mult(int x, int y) {
		long start=System.nanoTime();
		int result=x*y;
		long end=System.nanoTime();
		System.out.printf("처리시간 :%dns\n",(end-start));
		return result;
	}

	@Override
	public int div(int x, int y) {
		long start=System.nanoTime();
		int result=x/y;
		long end=System.nanoTime();
		System.out.printf("처리시간 :%dns\n",(end-start));
		return result;
	}

}
