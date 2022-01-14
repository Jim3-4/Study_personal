package smhrd;
class Earth{
	static final double EARTH_DOUBLE=6400;
	static final double EARTH_SURFACE;
	static {
		EARTH_SURFACE=4*Math.PI*EARTH_DOUBLE;
	}
}

public class CalExam {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Earth.EARTH_SURFACE);
		System.out.println(Earth.EARTH_DOUBLE);
		 
	}

}
