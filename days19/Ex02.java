package days19;

import java.io.Serializable;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오전 10:10:53
 * @subject 
 * @content 
 */
public class Ex02 {

	public static void main(String[] args) {
		// p 392 ~ p396 페이지 설명 - 스타크래프트 게임
		// [테란 종족]  SCV - 자원 ,  수리 

	} // main

} // class

/*
public interface Serializable {
  // X
}
*/

// [직렬화]가 가능한 클래스
class Unit implements Serializable{	
}

class GroundUnit extends Unit{  // 지상유닛	
}

class AirUnit extends Unit{          // 공중유닛	
}

class SCV extends GroundUnit  implements Repairable{    // 
	
	void 자원캐는메서드(){
		
	}
	
	//                           인터페이스 매개변수 다형성 
    void unitRepaire(  Repairable unit  ) {
    	// 수리 작업( 코딩 )
    }
    
}

// SCV가 [수리 가능한 유닛]
class Tank extends GroundUnit implements Repairable{  // 탱크       수리 O
	// 오버라이딩 X
}
class DropShip extends AirUnit implements Repairable{  // 수송선        수리 O
	
}
class Marine extends GroundUnit{   // 보병       수리 X
	
}

interface Repairable{
	// 멤버도 선언 X
}






