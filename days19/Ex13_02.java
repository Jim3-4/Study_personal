package days19;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author kenik
 * @date 2022. 3. 16. - 오후 3:08:07
 * @subject   
 * @content    C 9 유용한 클래스
 *                      C 10 날짜/시간
 *                      C 11 컬렉션 프레임워크
 *                      C 12 지네릭스,열거형, 어노테이션 @override
 *                      C 15 입출력(I/O)
 *                      C 13 스레드
 *                      C 16 네트워크
 */
public class Ex13_02 {

	public static void main(String[] args) throws IOException{
		  
		try {
		  int kor = getScore();
		
		System.out.println(kor );
		}catch(ScoreOutOfBoundException e) {
			System.out.println( e.getERROR_CODE() );
			System.out.println( e.getMessage() );
		}catch(Exception e) {
			
		}

	}
	
	// Chapter 14 람다와 스트림 X
	
	// 0~100 점수를 입력 반환하는 메서드
	public static int getScore() throws ScoreOutOfBoundException{
		Scanner scanner = new Scanner(System.in);
		int score;
		
		System.out.print("점수 입력 ? ");
		// scanner.nextInt()
		String data =  scanner.next();
		
		if( data.matches("[1-9]?\\d|100" ) ) {   // 0~100
			score = Integer.parseInt(data) ;
			return score;
		}else { 
			// "사용자 정의 예외 클래스" 사용
			//throw new ScoreOutOfBoundException("점수 범위( 0 ~ 100 ) 벗어났다.");
			throw new ScoreOutOfBoundException( 1001, "점수 범위( 0 ~ 100 ) 벗어났다.");
		}
	}
	
	// 메서드 선언 부분
	/*
	void method() throws NullPointerException, ArithmeticException, IOException{
		
	}
	*/

}
