package days17;

/**
 * @author 지민
 * @date 2022. 3. 14. - 오후 3:48:20
 * @subject 
 * @content 
 * 
 */
public class Ex08_03 {
	//상속계층도 salesman-> regular->employee->Object
	//상수필드 
	public final static double PI=3.141592;
	public final int MAX_VALUE; //기본값초기화 , 명시적초기화 
	
	Ex08_03(int value){
		MAX_VALUE=value;
	}
	
	public static void main(String[] args) {

		//지역변수는 접근지정자 못붙인다. 
		final double PI=3.141592;
		disp(100);
		//생성자 호출 순서 기억
		Employee emp4=new SalesMan("백경환","서울 강남구","010-3423-2342","2017-01-23",5000000,20,75000);
		emp4.dispEmpInfo();// 재정의된 메소드 호출 
		//System.out.println(emp4.getPay()); 부모 employee에 getPay 메소드가 없다. 
	}

	private static void disp(final int i) {
		// TODO Auto-generated method stub
		// i+=1000;   X 에러남 
		System.out.println("i="+i);
	}
	
}
