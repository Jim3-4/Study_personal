package days11;

import java.util.Random;
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
	// 5:10 수업 시작~
	// [한 반에 30명의 학생 성적 처리 ]
	// 이름, 국어, 영어, 수학, 총점, 평균, 등수를 처리하는 코딩...
	// 5:10 수업 시작~
	// [한 반에 30명의 학생 성적 처리 ]
	// 이름, 국어, 영어, 수학, 총점, 평균, 등수를 처리하는 코딩...
	Scanner scanner = new Scanner(System.in);
	
	final int STUDENT_COUNT = 30;
	
	String [] names = new String[STUDENT_COUNT];
	int [] kors = new int[STUDENT_COUNT];
	int [] engs = new int[STUDENT_COUNT];
	int [] mats = new int[STUDENT_COUNT];
	int [] tots = new int[STUDENT_COUNT];
	double [] avgs = new double[STUDENT_COUNT];
	int [] ranks = new int[STUDENT_COUNT];
	// 입력받은 학생의 수 +  각 배열의 채워넣을 위치( idx )
	int cnt = 0; 
    char con = 'y';
    
    do {
    	 System.out.printf("> [ %d] 번 이름 국어 영어 수학 입력하세요 ? ", cnt+1);	
    	 String name = scanner.next();
    	 int kor = scanner.nextInt();
    	 int eng = scanner.nextInt();
    	 int mat = scanner.nextInt();
    	 int tot = kor + eng + mat;
    	 double avg = (double)tot/ 3;
    	 int rank = 1;
    	
    	 names[cnt] = name;
    	 kors[cnt] = kor;
    	 engs[cnt] = eng;
    	 mats[cnt] = mat;
    	 tots[cnt] = tot;
    	 avgs[cnt] = avg;
    	 ranks[cnt] = rank;
    	
    	 cnt++;  // 입력받은 학생 수는 1증가, +  각 배열의 채워넣을 위치( idx ) 1증가
    	 
    	System.out.print("> 계속 할거냐 ? ");
		con = scanner.next().charAt(0);
	} while (    Character.toUpperCase(con) == 'Y' );

    System.out.println("> 입력받은 학생수 : " + cnt + "명");
    
    // 등수 처리 코딩 - ( 내일 설명 )
    
    
    // 입력받은 학생 정보 출력
    for (int i = 0; i < cnt; i++) {
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n"
				, names[i] , kors[i] , engs[i],  mats[i] , tots[i], avgs[i], ranks[i]);
	}

      
}//main

/**
 * @return
 */
private static String getRandomName() {
	// TODO Auto-generated method stub
	Random rnd=new  Random();
	String name= null;
	char[] names=new char[5];
	for(int i=0; i<names.length; i++) {
		names[i]= (char)(rnd.nextInt(26)+65);
	}
	
	name=new String(names);
	return name;
}

/**
 * @return
 */
private static int getRandomScore() {
	// TODO Auto-generated method stub
	Random rnd=new Random();
	return rnd.nextInt(101);
}
}//class