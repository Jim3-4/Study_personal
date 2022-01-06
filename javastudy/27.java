package smhrd;
class Cal{
	static String company="Samsung";
	static String model="LCD";
	static String info;
	
	static {
		info=company+" and "+model;
	}
}

public class CalExam {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Cal.info);
	
	}

}
