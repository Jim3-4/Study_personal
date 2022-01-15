public package smhrd;
class Car1{
	private int speed;
	private boolean stop;
	
	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int speed) {
		if(speed<0) {
			this.speed=0;
			return;
		}else {
			this.speed=speed;
		}
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop() {
		this.stop=stop;
		this.speed=0;
	}
}
public class CarExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car1 myCar=new Car1();
		
		myCar.setSpeed(-3);
		System.out.println(myCar.getSpeed());
		
		myCar.setStop();
		System.out.println(myCar.isStop());
		
		myCar.setSpeed(30);
		System.out.println(myCar.getSpeed());
	}

}
class 33 {
    
}
