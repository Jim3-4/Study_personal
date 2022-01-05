package smhrd;
class Car{
	String company="현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	Car(){}
	Car(String model, String color){
		this(model,color,256);
	}
	Car(String model, String color, int maxSpeed){
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	
	
}
public class CarExample  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car c1=new Car();
		Car c2=new Car("black","boll");
		Car c3=new Car("black","bod",234);
		
		System.out.println(c3.color);
		System.out.println(c3.company);
		System.out.println(c2.maxSpeed);
	}
}
