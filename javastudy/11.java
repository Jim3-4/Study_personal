package smhrd;

import java.io.IOException;
import java.util.Scanner;

public class Exam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String nam=scanner.nextLine();
		System.out.println("프로그램 종료햐려면 q누르기 ");
		
		do {
			System.out.println(">");
			nam=scanner.nextLine();
			System.out.println(nam);
		}while(!nam.equals("q"));	
	}
}
