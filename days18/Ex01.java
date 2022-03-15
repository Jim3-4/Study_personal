package days18;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오전 8:12:22
 * @subject 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		// >18	2022-03-15(화)<
		// 9:25 수업 시작~ 
		// [상속계층도]
		//               Object = 멤버
        //                  ↑
		//             Employee
		//                n,a,t,h
		//                dispEmpInfo()
		//                  ↑
		//  Regular                  Temp
		//      pay                        days, pOd
		//      getPay()                getPay()
		//     오버라이딩 dEI()           X
		//       ↑
		//  SalesMan final
		//      comm, sales
		//      오버라이딩 getPay() 
		//      오버라이딩 dEI() 
		/*
		E emp= new E();
		emp.dispEmpInfo();
		*/
		// [ 다형성 ] 오토 업캐스팅
		/*
		Employee emp = new Regular();
		// 문제점
		// 확인
		 */
		// 생성자가 호출되는 순서 ( 기억 )
		/*
		Employee emp = new SalesMan();
		
		ㄱ. Employee 생성자
		ㄴ. Regular 생성자
		ㄷ. SalesMan 생성자
		*/
	} // main

} // class









/* [ 수업 예제]
 * 1. 상속 정의 및 장점
 * 2. 윈도우의 닫기 버튼을 클릭할때 이벤트 처리 방법 설명
 * 3. 단일 상속과 다중 상속 설명
 * 4. 클래스들 간의 관계
 *   ㄱ.
 *   ㄴ. 
 * 5. 결합력이 높은 코딩이란 ?
 * 5-2. 생성자를 통한 의존성 주입( DI) 와 setter 를 통한 의존성 주입( DI ) 설명
 * 6. this 정의와 3가지 용도
 * 6-2. super 정의와 3가지 용도
 * 7. 업캐스팅과 다운캐스팅 설명
 * 8. final 클래스 
 *     final 메서드
 *     final 변수
 * 9. java.lang.Object 클래스 설명    
 * 8. 생성자 호출 순서 
 * */
