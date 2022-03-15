package days18;

import days17.Employee;
import days17.Regular;
import days17.SalesMan;
import days17.Temp;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오전 10:20:03
 * @subject 
 * @content 
 */
public class Ex03 {

	public static void main(String[] args) {
		// p 344
		// 제어자( modifier ) ? 클래스, 변수, 메서드       선언할 때 함께 사용하여 부가적인 의미 부여하는 것.
		// 2가지 종류 :  접근 지정자 , 기타제어자
		
		// p 347 abstract 키워드  
		// p 354 [다양성] ? 다양한 성질
		//    - OOP  중요한 특징 ***
		//    - "여러 가지 형태를 가질 수 있는 능력"을 의미
		//    예) 쉬는 시간에          사람(학생)들에게                화장실갔다오세요(일/기능) 메서드
		//                                               ㄴ  남학생(실체) -  남자화장실 이용
		//                                                ㄴ  여학생         -  여자화장실 이용
		//    예) 초등학교 산수 시험 시간
		//          각 [ 도형  ]의 면적을 구하세요(일/기능)   메서드
		//                               삼각형(실체) -                 1/2*가로*세로
		//                                사각형-                 가로*세로
		//                               원       -                  반지름*반지름*PI
		//                               마름모 -
		//                               타원   -
		
		//  - 자바에서
		//    한 타입의 참조변수로   여러 타입의 객체를 참조할 수 있도록 함으로써 다형성을
		//    프로그램적으로 구현하였다.
		
		// 사원들 정보 출력하세요 () - dispEmpInfo() 메서드를 호출
		// 다형성을 구현하는 기술 : 업캐스팅/다운캐스팅, 오버라이딩/오버로딩
		/* 
        Employee emp2 = new Regular("김재우","서울 강남구", "010-2342-4423", "2019-03-05", 3000000);
		Employee emp4 = new SalesMan("백경환", "서울 강남구", "010-8237-2342", "2017-01-12", 500000, 20, 75000);
		Employee emp5 = new Temp("정도연", "경기도 남양주", "010-8278-8888", "2020-04-09", 21, 100000);
		
		emp2.dispEmpInfo();
		emp4.dispEmpInfo();
		emp5.dispEmpInfo();
		*/
		
		// 객체 배열  초기화
		Employee [] emps = {
				 new Regular("김재우","서울 강남구", "010-2342-4423", "2019-03-05", 3000000) ,
				 new SalesMan("백경환", "서울 강남구", "010-8237-2342", "2017-01-12", 500000, 20, 75000) ,
				 new Temp("정도연", "경기도 남양주", "010-8278-8888", "2020-04-09", 21, 100000) 
				 // 5만 사원
		};
		for (int i = 0; i < emps.length; i++) {
			// emps[i].dispEmpInfo();
			System.out.println(  emps[i].getPay() );
		}

	} // main

} // class











