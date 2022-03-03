package days11;

import java.util.Scanner;

/**
 * @author 지민
 * @date 2022. 3. 3. - 오후 5:13:55
 * @subject 
 * @content 
 * 
 */
public class Ex07 {

public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String [] names= new String[30];
	int[] kors=new int[30];
	int[] engs=new int[30];
	int[] mats=new int[30];
	int[] tots=new int[30];
double[] avgs=new double[30];
int[] ranks=new int[30];
int cnt=0; //입력받은 학생의 수 +각 배열의 채워넣을 위치(idx)
char con='y';

do {
	System.out.println("이름 국어 영어 수학 입력");
	System.out.println("계속할거니");
	System.out.println("계속할거니");
	con=sc.next().charAt(0);
} while (Character.toUpperCase(con)=='Y');
writeScore();
}

/**
 * 
 */
private static void writeScore() {
	// TODO Auto-generated method stub
	
}
}
