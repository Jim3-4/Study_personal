package two;

public class Computer extends Calcul{



	@Override
	double areaCicrle(double r) {
		// TODO Auto-generated method stub
		System.out.println("computer 객체의 넓이");
		return Math.PI*r*r;
	}
}
