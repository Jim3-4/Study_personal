package two;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car=new Car();
		for(int i=0; i<=5;i++) {
			int problemLocation=car.run();
		
		
		switch(problemLocation) {
		case 1:
			System.out.println("앞왼쪽 hankookTire로 교체");
			car.fltire=new HankookTire("앞왼쪽",15);
			break;
		case 2:
			System.out.println("앞오른쪽 KumhoTire로 교체");
			car.frtire=new KumhoTire("앞오른쪽",13);
			break;
		case 3:
			System.out.println("뒷왼쪽 Hankkoktire로 교체");
			car.bltire=new HankookTire("뒷왼쪽", 14);
			break;
		case 4:
			System.out.println("뒷오른쪽 Kumhotire");
			car.brtire=new KumhoTire("뒷오른쪽",17);
			break;
		}
		System.out.println("---------------");
	}
	}
}
