package eightInterface;

public class Car {
	Tire front1Tire=new HankookTire();
	Tire front2Tire=new HankookTire();
	Tire front3Tire=new HankookTire();
	Tire front4Tire=new HankookTire();
	
	void run() {
		front1Tire.roll();
		front2Tire.roll();
		front3Tire.roll();
		front4Tire.roll();
	}
}
