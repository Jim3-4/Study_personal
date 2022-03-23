package days24;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author kenik
 * @date 2022. 3. 23. - 오후 3:39:39
 * @subject 
 * @content 
 */
public class Ex10 {

	public static void main(String[] args) {
		// p 588 Vector 컬렉션 클래스 
		//    C 인터페이스
		//    [ List 인터페이스 ]   :  순서유지된다. 중복허용한다. 
		//     구현한 클래스 - ArrayList, Vector( 멀티스레드 안전 == 동기화 처리되어져 있다)
		
		// Vector v = new Vector(10, 0);
		Vector v = new Vector();
		
		v.addElement("이채영");
		v.add("정도연");
		
		System.out.println(  v.size() );          // 객체의 수 2
		System.out.println(  v.capacity() );  // 용량의 수 10
		
		v.trimToSize();
		
		System.out.println(  v.capacity() );  // 용량의 수 2
		
		// 요소의 갯수 증가 + null 로 채워서
		// v.setSize(6);
		System.out.println(  v.size() );          // 객체의 수 6
		System.out.println(  v.capacity() );  // 용량의 수 6
		System.out.println(v ); // [이채영, 정도연, null, null, null, null]
		//                                              0요소   1요소    2요소( Element)
		
		// 4:04 수업 시작.
	     System.out.println( v.get(0) );              // 이채영    C-L
	     System.out.println( v.elementAt(0) );  // 이채영    C-L-Vector( elementAt() )
	     
	     // v.copyInto(args);  // 복사
	     
	     // 모든 요소(element) 를 반환하는 메서드 
	     // Enumeration 열거자 
	     Enumeration  en =   v.elements();
	     // hasMoreElements() 요소 더 있냐?  [ true ]  / false
	     // nextElement() 다음 요소를 가져와서 반환하는 메서드
	     while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			System.out.println( name );
		}
	     
	     // 반복자 ( 암기 ) 
	     // 열거자 ( 암기 )
	     // 반복자와 열거자의 차이점 ?        [fail-fast]
	     
	     // 첫번째 요소 :  v.firstElement()  == v.get(0) == v.elementAt(0)
	     // 마지막 요소 : v.lastElement() == v.get(v.size()-1)
	     
	     // 요소 삽입 :  v.insertElementAt( 요소,  위치(index)); ==	     v.add(요소,  위치(index));

	     //  v.[list]Iterator(0)
	     
//	     v.remove(인덱스);
//	     v.remove(객체);
//	     v.removeElementAt(인덱스);
//	     v.removeElement(객체)
	     
	     // Object [] toArray()           -> String [] 
	     String []  m =  (String [] )v.toArray();
	      
	     
	     
	     // Stringbuffer 와 [StringBuilder] 클래스
	     // ArrayList와 [Vector] 컬렉션 클래스의 차이점 :    동기화처리(멀티스레드 안전)
	} // main

} // class













