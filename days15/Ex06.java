package days15;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 지민
 * @date 2022. 3. 10. - 오후 11:17:55
 * @subject 
 * @content 
 * 
 */
public class Ex06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		final int STUDENT_COUNT=30;
		Student[] students=new Student[STUDENT_COUNT];
		int cnt=0;
		char con='y';
		
		do {
			int no=cnt+1;
			System.out.printf("%d번 이름 국어 영어 수학 입력");
			String name=getRandomName();
			int kor=getRandomScore();
			int eng=getRandomScore();
			int mat=getRandomScore();
			int tot=kor+eng+mat;
			double avg=(double) tot/3;
			int rank;
			
			students[cnt] =new Student();
			students[cnt].no=no;
			students[cnt].name=name;
			students[cnt].kor=kor;
			students[cnt].eng=eng;
			students[cnt].mat=mat;
			students[cnt].tot=tot;
			students[cnt].avg=avg;
			students[cnt].rank=rank;
			
			cnt++;
			
			System.out.println("계속할꺼니");
			con=sc.next().charAt(0);
			
		}while(Character.toUpperCase(con)=='Y');
		
		System.out.println("입력받은 학생수"+cnt+"명");
	
		for(int  j=0; j<cnt; j++) {
			for(int i=0; i<cnt; i++) {
				if(students[i].tot<students[j].tot) {
					students[j].rank++;
				}
			}
		}
		
		for(int i=0; i<cnt; i++) {
			students[i].printInfo();
		}
	
		
	}

	/**
	 * @return
	 */
	private static int getRandomScore() {
		// TODO Auto-generated method stub
		Random rnd=new Random();
		return rnd.nextInt(101);
	}

	/**
	 * @return
	 */
	private static String getRandomName() {
		// TODO Auto-generated method stub
		String name=null;
		Random rnd=new Random();
		char[] names= new char[5];
		for(int i=0;i<names.length; i++) {
			names[i]=(char)(rnd.nextInt(26)+65);
		}
		name=new String(names);
		return name;
	}

}
