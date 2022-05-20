package days20;

/**
 * @author kenik
 * @date 2022. 3. 17. - 오전 11:04:10
 * @subject 
 * @content // p 456 Object.clone() 메서드 - 복제.. 
		              // 11:05  수업시작~ 
 */
public class Ex02 {

	public static void main(String[] args) {
		// 
		/*
		MyPoint p1 = new MyPoint(1, 2);
		MyPoint p2 = new MyPoint(1, 2);
		// p1 x,y좌표와 p2 x,y좌표 같은지 확인.. true
		System.out.println(  p1.equals(p2) );  // false    ->        true
		// Object.equals() 메서드는 인스턴스의 참조주소값을 비교하기 때문에 false		
		// MyPoint.equals() 오버라이딩....두 좌표의 x,y 값만 같다면 같은 좌표라고 true 반환.
		*/
		
		// 복제( clone )
		MyPoint p1 = new MyPoint(1, 2);
		// MyPoint p2 = p1;  복사
		
		/* [ p1 복제.... ]
		MyPoint p2 = new MyPoint(p1);
		System.out.println( p1.hashCode() +  "  /  " + p2.hashCode()  );  // 366712642  /  1829164700
		System.out.println( p1 ); // > x=1, y=2
		System.out.println( p2 ); // > x=1, y=2
        */
		
		// 5. Object.clone() 복제 메서드 오버라이딩
		// p457 공변 반환타입
		// MyPoint  p2 = ( MyPoint) p1.clone();
		 MyPoint  p2 =  p1.clone();
		
		System.out.println( p2 );
		
	} // main

} // class


// 질문
// 혹시 방금한 Ex01에서 
// Value 클래스 equlas 메서드 오버라이딩 하는 부분
// 다시 한번만 설명 부탁드려도 될까요? 이해가 잘 안됩니다.








