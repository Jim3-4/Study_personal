package two;

public class Dog extends Animal{
public Dog() {this.kind="포유류";}
public void sound() {
	System.out.println("멍멍");
}

}
npackage eightInterface;

public class RemoteControlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc=null;
		
		rc=new Television();
		rc.turnOff();
		rc.setMute(false);
		
		rc=new Audio();
		rc.setMute(false);
	}

}
