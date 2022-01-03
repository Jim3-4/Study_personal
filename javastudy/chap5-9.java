package smhrd;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run=true;
		int studentNum=0;
		int[] scores=null;
		Scanner scanner =new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------");
			System.out.println("1.학생수 2.점수입력 3. 점수리스트 4.분석 5.종료");
			System.out.println("------------------");
			System.out.println("선택>");
			
			int selectNo=scanner.nextInt();
			
			if(selectNo==1) {
				System.out.println("학생수를 입력");
				studentNum=scanner.nextInt();
			}else if(selectNo==2) {
				scores=new int[studentNum];
				for(int i=0; i<studentNum; i++) {
					System.out.print("scores["+i+"]"+">");
					int sc=scanner.nextInt();
					scores[i]=sc;
				}
			}else if(selectNo==3) {
				System.out.println("점수리스트");
				for(int i=0; i<studentNum; i++) {
					System.out.println("scores["+i+"]"+scores[i]);
				}
			}else if(selectNo==4) {
				int max=0, sum=0;
				double avg=0.0;
				for(int i=0;i<studentNum; i++) {
					if(max<i) max=scores[i];
					sum+=scores[i];
				}
				avg=sum/studentNum;
				System.out.println("최고점수는 :"+max);
				System.out.println("평균점수는 :"+avg);
			}else if(selectNo==5) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}