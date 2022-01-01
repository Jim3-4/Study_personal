package smhrd;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int score=(int)(Math.random()*20)+81;
	
	if(score>=90) {
		if(score>=95) {
			System.out.println("A+");
		}else {
			System.out.println("A");
		}
	}else if(score>=80) {
		if(score>=85) {
			System.out.println("B+");
		}else {
			System.out.println("B");
		}
	}else if(score>=70) {
		if(score>=75) {
			System.out.println("C+");
		}else {
			System.out.println("C");
		}
	}else {
		System.out.println("D");
	}
	}

}
