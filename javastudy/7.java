package smhrd;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=(int)(Math.random()*6)+1;
		
		if(num==1) {
			System.out.println("1이나왔습니다.");
		}else if(num==2){
			System.out.println("2이 나왔습니다. ");
			
		}else if(num==3){
			System.out.println("3이 나왔습니다.");
			
		}
		else if(num==4){
			System.out.println("4가 나왔습니다.");
			
		}
		else if(num==5){
			System.out.println("5가 나왔습니다.");
			
		}else{
			System.out.println("6이 나왔습니다.");

		}
	}

}
