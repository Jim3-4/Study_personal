package smhrd;

import java.io.IOException;

public class Exam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean run=true;
		int speed=0;
		int keyCode=0;
		
		while(run) {
			if(keyCode!=13 && keyCode!=10) {
				System.out.println("---------");
				System.out.println("1.증속 2.감속 3.중지");
				System.out.println("----------");
				System.out.println("선택");
			}
			keyCode=System.in.read();
			
			if(keyCode ==49) {
				speed++;
				System.out.println("현재속도:"+speed);
			}else if(keyCode==50) {
				speed--;
				System.out.println("현재속도"+speed);
			}else if(keyCode==51){
				run=false;
			}
			
		}
		System.out.println("프로그램종료");
	
	
	}
}
