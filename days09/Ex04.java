package day09;

/**
 * @author 지민
 * @date 2022. 2. 25. - 오후 12:02:47
 * @subject 
 * @content 
 * 
 */
public class Ex04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int ranNum=(int)(Math.random()*45+1);
		// 12:02  수업 시작~
				// 금요일 - 명칭 [로또645]        요구 분석 -> 1. 요구분석서 작성
				// (주)동행복권 
				//           ㄴ 단말기 ( 판매점 )
				//           ㄴ 인터넷 
				
				// 1. 온라인 복권
				// 2. 수동/자동/반자동
				// 3. 1등금액           - 판매량
				// 4. 1등 X -> 2회 이월 제한
				// 5. 연중 무휴
				//     추첨일(토요일)  오후 8~ 다음날(6시) X
				// 6. 만 19세 미만 구매 X
				// 7.   645( 1~45 ) -> 6 뽑아요 
				
				// 1~45 정수 	                0.0 <=  실수	Math.random()   < 1.0
				// 0~44 정수 + 1           1 <=   정수	 (int)(Math.random()*45) +1   <= 45
				
				for (int i = 1; i <= 6 ; i++) {
					System.out.println(           (int)(Math.random()*45) +1           );
				}

			} 

		/*
			16
			12 *****
			35
			12 *****  중복된 숫자 발생
			1
			11
			
			[중복체크]이전 발생한 로또번호랑 지금 발생한 로또번호가 중복 체크 한 후 ..
			Ex04_02.java 
		*/
	}

}
