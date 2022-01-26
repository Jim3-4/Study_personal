package eightInterface;

public class Audio implements RemoteControl{
private int volume;

@Override
public void turnOn() {
	// TODO Auto-generated method stub
	System.out.println("audio를 켭니다.");
}

@Override
public void turnOff() {
	// TODO Auto-generated method stub
	System.out.println("audio 끕니다.");
}

@Override
public void setVolume(int volume) {
	// TODO Auto-generated method stub
	
		// TODO Auto-generated method stub
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume=RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume=RemoteControl.MIN_VOLUME;
		}else {
			this.volume=volume;
		}
		System.out.println("볼륨은"+volume);
	}

@Override
public void setMute(boolean mute) {
	if(mute) {
		System.out.println("audio 무음처리합니다.");
	}else {
		System.out.println("audio 무음 해제합니다.");
	}
}

}
