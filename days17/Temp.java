package days17;

/**
 * @author 지민
 * @date 2022. 3. 14. - 오후 4:46:42
 * @subject 
 * @content 
 * 
 */
public class Temp extends Employee {
	private int days;
	private int payOfDay; //하루일당
	
	public Temp(String name, String addr, String tel, String hiredate,int days, int payOfDay) {
		super(name,addr, tel,hiredate);
		this.days=days;
		this.payOfDay=payOfDay;
		System.out.println("Temp 생성자6개 호출됨 ");
	}
	public void dispEmpInfo() {
		// TODO Auto-generated method stub
		super.dispEmpInfo();
		System.out.printf("근무일수 : %d, 하루일당: %d", days, payOfDay);
		
	}
	public int getPay() {
		return this.days*this.payOfDay;
	}
}
