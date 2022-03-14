package days17;

/**
 * @author 지민
 * @date 2022. 3. 14. - 오후 2:29:59
 * @subject 
 * @content 
 * 
 */
//정규직사원클래스 
public class Regular extends Employee {
	//물려받은 필드 4개 , 
	private int pay; //기본급 
	
	//생성자와 초기화 블럭은 상속되지 않는다 .

	public Regular() {
		System.out.println("regular 디폴트생성자 호출 ");
	}
	
	//The field Employee.hiredate is ^ not visible^
	//접근지정자가 문제 
	public Regular(String name, String addr, String tel, String hiredate,int pay) {
		super(name,addr, tel,hiredate);
		this.pay=pay;
		System.out.println("생성자5개 호출됨 ");
	}

	@Override 
	//어노테이션 (부모의 메소드를 재정의 ) 
	public void dispEmpInfo() {
		// TODO Auto-generated method stub
		super.dispEmpInfo();
		System.out.printf("기본급 : %d",pay);
	}
	public int getPay() {
		return pay;
	}
}
