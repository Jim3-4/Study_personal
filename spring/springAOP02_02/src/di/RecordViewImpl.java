package di;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class RecordViewImpl implements RecordView {
	/*
	 * RecordImpl 스프링 빈객체가 생성되면
	 *  <bean id="record" class="di.RecordImpl"></bean> 
	 *  자동으로 의존 주입(DI)
	 */

	
	@Autowired
	private RecordImpl record =null;
	/* xml에서 <bean id="record2" class="di.RecordImpl"></bean> */
	//@Resource(name="record2")
	//private RecordImpl record =null;


	//생성자 방식과 프로퍼티 설정 방식 
	public RecordViewImpl() {
		this.record=new RecordImpl();
	}
	
	//생성자 의존성주입방식
	public RecordViewImpl(RecordImpl record) {
		this.record=record;
	}
	
	//프로퍼티 의존성 주입방식
	public void setRecord(RecordImpl record) {
		this.record=record;
	}
	@Override
	public void input() {
		try(Scanner scanner= new Scanner(System.in)){
			System.out.println("kor,eng,mat input?");
			int kor=scanner.nextInt();
			int eng=scanner.nextInt();
			int mat=scanner.nextInt();
		
			this.record.setKor(kor);
			this.record.setEng(eng);
			this.record.setMat(mat);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void output() {
	System.out.printf("kor:%d , eng:%d , mat:%d, tot:%d, avg =%.2f\n"
				,this.record.getKor()
				,this.record.getEng()
				,this.record.getMat()
				,this.record.total()
				,this.record.avg()
			);
	

	}

}
