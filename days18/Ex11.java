package days18;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오후 2:44:51
 * @subject 
 * @content 
 */
public class Ex11 {

	public static void main(String[] args) {
		//  접근지정자 + 멤버( 필드, 메서드 )  days15.Ex07.java  
		//   p348
		//   범위가 넓은쪽  public > protected > (default) > private   좁은쪽
		
		//  1) public       :   어디서든지 (  패키지 내/외부 ) 접근 가능 
		//  2) [ protected ]   :  패키지 내부 접근 가능 + 상속개념( 상속 관계가 있는 자식클래스에서 접근 가능 )
         // 3) default    :   패키지 내부 접근 가능
		//  4) private     :  같은 클래스 접근 가능
		
		// 3:05 수업 시작
		// days18.AccessModifier.java
		
		// 같은 패키지 안에 다른 클래스 코딩.. 
		AccessModifier am = new AccessModifier();
		// am.pub;		am.pro; 		am.def;  접근가능.
		
		
		
		// ******* p 381 인터페이스 *******

	} // main

} // class
