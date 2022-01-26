package eightInterface;

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
