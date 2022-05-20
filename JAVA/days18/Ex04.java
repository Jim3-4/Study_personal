package days18;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오전 10:39:42
 * @subject 
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {
		// p 347 abstract 키워드  
		//   abstract 기타제어자를 붙여서 선언한 몸체가 없는 불완전한 메서드를  "추상메서드"라고 한다. 
		//  왜 추상 메서드를 선언하고 사용하는가 ? 답  E(getPay X)  - > R/S/T getPay()
		//                                                                  emp.getPay() 호출 X
		//                                                                  
		// 11:11 수업 시작~

		
		// E - getPay() 급여 계산하는  메서드 X
		// R -재정의 getPay() <-  S - 재정의 getPay()
		// T -재정의 getPay()
		
		// 다형성   E = R ,  E =  S , E = T
		//              dispEmpInfo() 호출 가능
		//              getPay() 호출 가능 X
		
		//  추상클래스                   클래스         업캐스팅 가능
		// Employee emp2 = new Regular("김재우","서울 강남구", "010-2342-4423", "2019-03-05", 3000000);
		

	} // main

} // class















//질문
/*
책에서는 
업캐스팅을 하면은 E emp = new R();
자식인스턴스를 모두 사용할 수있는게 아니라      emp.getPay() X
부모한테 상속받은 인스턴스( 멤버 )만 사용할 수 있다는데
어떻게 자식의 dispEmpInfo가 사용되나요 ?

부모                       자식 클래스
E                          R
getPay()X           getPay() O
dEI()      O           재 dEI()    O
// 업캐스팅
E emp = new R();
emp.getPay() X
emp.dEI()       O  ????  왜 
*/