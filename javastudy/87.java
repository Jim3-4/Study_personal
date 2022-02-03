package twoInterface;

public class AnonymousExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anonymose anony=new Anonymose();
		anony.field.turnOn();
		anony.method1();
		anony.method2(new RemoteControl() {

			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("smartTv를 켠다");
			}

			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("smartTv를 끈다");
			}
			
		});
		}
	}


