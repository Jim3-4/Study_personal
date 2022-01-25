package two;

public class SuperSonicAirplaneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SupersonicAirplane sa= new SupersonicAirplane();
		
		sa.takeOff();
		sa.fly();
		sa.flymode=SupersonicAirplane.SUPERSONIC;
		sa.fly();
		sa.flymode=SupersonicAirplane.NORMAL;
		sa.fly();
		sa.land();
	}

}
package two;

public class Airplane {
	public void land() {System.out.println("착륙해요");}
	public void fly() {System.out.println("일반비행해요");}
	public void takeOff() {System.out.println("이륙해요");}
}
