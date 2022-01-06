package smhrd;
class Cal{
	static double pi=3.1459;
	static int plus(int x, int y) {
		return x+y;
	}
	static int minus(int x, int y) {
		return x-y;
	}
}

public class CalExam {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		double res1=10*10*Cal.pi;
		System.out.println(res1);
		int res2=Cal.plus(109,4);
		System.out.println(res2);
		
		int res3=Cal.minus(130, 3);
		System.out.println(res3);
	}

}
