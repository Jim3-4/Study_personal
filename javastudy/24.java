package smhrd;
class Car{
	String company="현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	Car(){}
	Car(String model, String color){
		this.model=model;
		this.color=color;
	}
	
}
public class CarExample  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar=new Car();
		Car myCar2=new Car("pink","omo");
		
		System.out.println(myCar2.color);
	}

}
