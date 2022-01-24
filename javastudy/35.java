package two;

public class DmbCellphone extends CellPhone{
	int channel;
	
	DmbCellphone(String model, String color, int channel)
	{
		this.model=model;
		this.color=color;
		this.channel=channel;
	}
	void turnOnDmb() {
		System.out.println("채널"+channel+"번으로 바뀝니다.");
	}	
	void changeChannelDmb(int channel) {
		this.channel=channel;
		System.out.println("채널"+channel+"번으로 바꿉나다.");
	}
	void turnOffDmb() {
		System.out.println("dmb 방송 수신을 멈춥니다. ");
	}
}
