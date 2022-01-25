package two;

public class HankookTire extends Tire{

	public HankookTire(String location, int maxRotation) {
		super(location,maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location+"Tire 수명"+(maxRotation-accumulatedRotation));
			return true;
		}else {
			System.out.println("****"+location+"펑크");
			return false;
		}
}}
