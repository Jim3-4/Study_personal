package eightInterface;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar=new Car();
		
		myCar.run();
		
		myCar.front1Tire=new KumhoTire();
		
		myCar.run();
	}

}
