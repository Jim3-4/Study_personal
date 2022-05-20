package days24;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author kenik
 * @date 2022. 3. 23. - 오전 11:17:20
 * @subject 
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		// [ArrayList 컬렉션 클래스 ]
		// 1. 가장 많이 사용되는 컬렉션 클래스
		// 2. List 인터페이스를 구현한 클래스
		// 3. 특징 : 순서유지O, 중복허용O
		
		// [ 배열(array) 의 단점 ]
		// 1. 배열 크기 자동 증가 X
		// 2. 배열 삽입(insert)
		//   [1][4][2][3]  배열크기증가 + 쉬프트 +  저장
		// 3. 삭제( remove )
		// [1][2][3][0]  왼쪽 쉬프트  + 마지막 요소 초기화
		// 4. 모든 배열의 요소 삭제등등
		// 5. 
		// int [] m = new int[3];  // 0 , 1, 2
		
		// C 12 - <E - Element> 지네릭스( generics ), 제네릭
		ArrayList list = new ArrayList(3);  // 초기 용량 10개
		
		// 요소(Element) 추가
		list.add(100);  // int -> Integer 오토박싱 -> Object 
		list.add(200);  // int -> Integer 오토박싱 -> Object 
		list.add(300);  // int -> Integer 오토박싱 -> Object 
		
		list.add(400);  // int -> Integer 오토박싱 -> Object 
		
		// 자동 크기 증가 되더라... (  배열보다 편리하더라 )
		//System.out.println(   list.size() );  // 저장된 객체 갯수 반환하는 메서드  int
		
		// 요소(element) 출력
		/*
		System.out.println(  list.get(0) );
		System.out.println(  list.get(1) );
		System.out.println(  list.get(2) );
		System.out.println(  list.get(3) );
		*/		 
		
		// 1 번째 위치(index)  500 값을 삽입
		list.add(1, 500);
		
		 //  500 값을 삭제(제거)
		// 수정 또는 삭제하려면 검색 먼저 한다. 
		
		// System.out.println( list.contains( 700 ) ? "있다" : "없다");
		// boolean contains()            몇 번째 위치(index) 값을 알아야 된다. 		
		// System.out.println( list.indexOf(500) ); // -1
		int findIndex = list.indexOf(500);
		
		if (  findIndex == -1) {  // 찾는 500이 없다. 
			System.out.println("arraylist에서 찾는 값(객체)는 없습니다.");
			return;
		} else { // 있다. -> 삭제 코딩.
			//list.remove(findIndex); // int index
			// list.remove(500); // Object o  ->   int index
			list.remove(    new Integer(500)      );
		}
		
		// 모든 요소를 삭제(제거)
		//list.clear();
		
		// [문제]    12:02 수업시작~
		// 300 을 찾아서 있으면  3으로 [수정] 
		//                         없으면 300 추가  - add()
		findIndex = list.indexOf(300);
		if (findIndex != -1) {
			// list.remove(findIndex);
			// list.add(findIndex, 3);
			list.set(findIndex, 3);  // set()
		} else {
			System.out.println("arraylist에서 찾는 값(객체)는 없습니다.");
			list.add(300);			
		}
		
		// dispList( list );
		System.out.println(  list.toString() );  // [100, 200, 3, 400]           Arrays.toString( m );
		
		// [문제] list 에서 200보다 같거나 큰 요소는 삭제하세요...
		// ****** Chapter 14 람다와 스트림            [ 수업X ]  *****
		list.removeIf(		(t)->	Integer.parseInt(t.toString()) >= 200	    );
		/*
		list.removeIf(
				    // 익명클래스                 new 인터페이스(){}            new 부모클래스(){}
				    // <T - Type>
				    new Predicate() { 
						@Override
						public boolean test(Object t) { 
							return   Integer.parseInt(t.toString()) >= 200;
						} 
		             } 
				 );
		*/
		
		// 에러 메시지 : java.lang.IndexOutOfBoundsException: Index: 3, Size: 2
		/*
		int listSize =  list.size();
		for (int i = listSize -1 ; i  >=0    ; i--) {
			// Object -> [오토언박싱] ->   int
			 if( (int)(list.get(i)) >= 200 ) {
				 // 제거
				 list.remove(i);
			 }
		}
		*/
		/*
		for (int j = 0; j < list.size(); j++) {
	         if( (int)(list.get(j)) >= 200) {
	            list.remove(j);
	         }
	      }
		*/
		System.out.println(  list.toString() ); 

	} //  main

	private static void dispList(ArrayList list) {
		int listSize =  list.size();
		for (int i = 0; i <  listSize ; i++) {
			System.out.println(  list.get(i) );
		}
	}

} // class


/*  [오후] 
for (int i = 0; i < list.size(); i++) {
	//Object > 오토언박싱 > int
	if ((int)list.get(i) >= 200) {
		//제거
		list.remove(i);
		 i--;   *****
	}
}
*/




