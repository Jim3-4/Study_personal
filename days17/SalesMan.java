package days17;

/**
 * @author 지민
 * @date 2022. 3. 14. - 오후 4:20:45
 * @subject 
 * @content 
 * 
 */
public final class SalesMan extends Regular {

	private int sales;
	private int comm;
	
	SalesMan(){
		System.out.println("디폴트 생성자 생성");
	}

	public SalesMan(String name, String addr, String tel, String hiredate, int pay,int sales, int comm) {
		super(name, addr, tel, hiredate, pay);
		this.sales=sales;
		this.comm=comm;
	}
	@Override
	public int getPay() {
		// TODO Auto-generated method stub
		return super.getPay()+this.comm*this.sales;
	}

	@Override
	public void dispEmpInfo() {
		// TODO Auto-generated method stub
		super.dispEmpInfo();
		System.out.printf("판매량:%d \t 커미션: %d\n", sales, comm);
		
	}
	
	
}
