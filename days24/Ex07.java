package days24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import days15.Student;

/**
 * @author kenik
 * @date 2022. 3. 23. - 오후 2:17:46
 * @subject  p 587 예제 11-2 
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) {
		// 배열 -> 컬렉션 클래스  추가/수정/삭제/크기 자동 증가 등등 용이
		// days11.Ex07.java  -- 1차원 배열
		// days15.Ex06.java -- Student 클래스  + 배열 
		// 30명 학생의 이,국,영,수,총,평,등 를 처리하는 코딩.
		
		Scanner scanner = new Scanner(System.in);
		final int STUDENT_COUNT = 30;
		
		ArrayList    list = new ArrayList(STUDENT_COUNT);
		
		int cnt = 0; 
		char con = 'y';

		do {
			int no = cnt + 1;
			System.out.printf("> [ %d] 번 이름 국어 영어 수학 입력하세요 ? ", no);		    	 
			String name = getRandomName() ;//scanner.next();
			int kor =   getRandomScore();// scanner.nextInt();
			int eng =  getRandomScore();//scanner.nextInt();
			int mat =  getRandomScore();//scanner.nextInt();
			int tot = kor + eng + mat;
			double avg = (double)tot/ 3;
			int rank = 1;
			int w_rank = 1;

			Student  s = new Student(no, name, kor, eng, mat, tot, rank, w_rank, avg);
			list.add(s);

			cnt++;  // 입력받은 학생 수는 1증가, +  각 배열의 채워넣을 위치( idx ) 1증가

			System.out.print("> 계속 할거냐 ? ");
			con = scanner.next().charAt(0);
		} while (    Character.toUpperCase(con) == 'Y' );

		// System.out.println("> 입력받은 학생수 : " + cnt + "명");
		System.out.println("> 입력받은 학생수 : " + list.size() + "명");

		// 3:06 풀이 ~
		// ㄴ. 등수처리
		for (int j = 0; j < list.size(); j++) {
			Student a = (Student) list.get(j); 
			for (int i = 0; i < cnt; i++) {
				Student b = (Student) list.get(i);
				if(    a.tot < b.tot  ) {  
					   a.rank++;
				}  // if
			} // for  i 
			// list.set(j, a);
		}  // for j 
		
		
		// ㄱ.  학생 정보 출력 (  반복자 사용해서 출력 )
		/*
		Iterator  ir =  list.iterator();
		while (ir.hasNext()) {
			Student s = (Student) ir.next();
			System.out.println(  s  );
		}
		*/
		
		// C 14 람다
		// ->  람다연산자
		// 람다식
		list.forEach(  s -> System.out.println(s)  );
		
		System.out.println("========================================");
		// 1. 복제
		ArrayList  listClone =(ArrayList) list.clone();
		// 2. 복제한 arrayList를 성적으로 오름차순 정렬
		// 에러메시지 :     java.lang.ClassCastException: days15.Student cannot be cast to java.lang.Comparable
		// 학생의 이름, 번호, 등수  비교할 정렬기준 X 
		
		listClone.sort(new StudentRankComparator());
		// Collections.sort(listClone ,  new StudentRankComparator() );
		/*
		Collections.sort(listClone , 
				new Comparator() {   // 익명클래스 사용..

					@Override
					public int compare(Object o1, Object o2) {
						if ( o1 instanceof Student && o2 instanceof Student ) {
							Student s1 = (Student) o1;
							Student s2 = (Student) o2;
							return s2.tot  - s1.tot;    // 0              양수                음수  오름차순 정렬
							// return s1.tot - s2.tot;  // 내림차순 정렬
						}
						return 0;
					}
		        }  
		);
		*/
		// 3. 복제한 arrayList 출력
		listClone.forEach(  s -> System.out.println(s)  );
		
		// 3:05 수업 시작~ 

	} // main

	public static String getRandomName() {
		String name = null; 
		Random rnd = new Random(); 
		char [] names = new char[5];      
		for (int i = 0; i < names.length; i++) {
			names[i] =  (char)( rnd.nextInt(26)+65);
		} 
		name = new String( names );		
		return name;
	}

	public static int getRandomScore() {
		Random rnd = new Random();
		return rnd.nextInt(101);
	}
	
} // class

// 학생의 정렬 기준 클래스 선언  [Comparator 인터페이스 구현]/ Comparable 인터페이스 구현
class StudentRankComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if ( o1 instanceof Student && o2 instanceof Student ) {
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			return s2.tot  - s1.tot;    // 0              양수                음수  오름차순 정렬
			// return s1.tot - s2.tot;  // 내림차순 정렬
		}
		return 0;
	}
	
}


