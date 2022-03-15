package days18;

import days17.Employee;
import days17.Regular;
import days17.SalesMan;
import days17.Temp;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오후 2:11:27
 * @subject   p370 여러 종류의 객체를 배열로 다루기
 * @content          ( 객체 배열 ) + 초기화 
 *                    p 376 추상 클래스/ 추상 메서드
 *                    
 *                    추상화 ? 클래스 간의 공통점을 찾아내서 공통의 조상을 만드는 작업
 *                    
 *                    모든 사원의 공통적인 멤버 클래스 : Employee
 *                    
 *                    Regular  클래스 
 *                    Salesman
 *                    Temp
 */
public class Ex09 {

	public static void main(String[] args) { 
		/*
		Employee [] emps = {
				 new Regular("김재우","서울 강남구", "010-2342-4423", "2019-03-05", 3000000) ,
				 new SalesMan("백경환", "서울 강남구", "010-8237-2342", "2017-01-12", 500000, 20, 75000) ,
				 new Temp("정도연", "경기도 남양주", "010-8278-8888", "2020-04-09", 21, 100000) 
				 // 5만 사원
		};
		*/
		
		/*
		Employee [] emps = new Employee[3];
		emps[0] = new Regular("김재우","서울 강남구", "010-2342-4423", "2019-03-05", 3000000);
		emps[1] = new SalesMan("백경환", "서울 강남구", "010-8237-2342", "2017-01-12", 500000, 20, 75000);
		emps[2] = new Temp("정도연", "경기도 남양주", "010-8278-8888", "2020-04-09", 21, 100000) ;
		 */ 
		
		/*
		Player                추상클래스
		↑
		AudioPlayer       추상클래스
		↑
		CDPlayer             클래스
		*/
		
	  /*	
	   AudioPlayer  player	 = new CDPlayer();
	   player.stop();
	   player.play(100);
	   */

		Player  player	 = new CDPlayer();
		player.stop();
		player.play(100);
		   
	} // main

} // class



abstract class Player{
	// 필드
	boolean pause;
	int currentPos;
	
	// 생성자
	Player(){		
	}
	// 메서드
	abstract void play(int pos);
	abstract void stop();
}


abstract class   AudioPlayer   extends Player{
	// 필드
	// 생성자
	// 메서드
	
	// 2개의 추상메서드를 오버라이딩(재정의)
	public void play(int pos) {
		System.out.println("추상메서드 몸체 구현함.");
	}
}


class CDPlayer extends AudioPlayer{

	
	// 필드
	// 생성자
	// 메서드 
	
	@Override
	void stop() {
		System.out.println("추상 메서드 몸체 구현함.");
	}
	
}












