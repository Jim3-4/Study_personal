package days18;

import days17.Employee;
import days17.Regular;
import days17.SalesMan;
import days17.Temp;

/**
 * @author kenik
 * @date 2022. 3. 15. - 오후 12:33:52
 * @subject   p 362 instanceof 연산자
 * @content  p 367  매개변수의 다형성 ***
 */
public class Ex08 {

	public static void main(String[] args) {
		// 
		Regular emp1 = new Regular("김재우","서울 강남구", "010-2342-4423", "2019-03-05", 3000000);
		SalesMan emp2 = new SalesMan("백경환", "서울 강남구", "010-8237-2342", "2017-01-12", 500000, 20, 75000);
		Temp emp3 = new Temp("정도연", "경기도 남양주", "010-8278-8888", "2020-04-09", 21, 100000);
		
		//printEmpPay(emp1);
		printEmpPay(emp2);
		//printEmpPay(emp3);
		// printEmpPay( new Temp2());
		
		// Employee <- Temp <-  class Temp2
		
	} // main

	// [ 매개변수의 다형성 ] 
	// Employee emp = Regular;    // 자동 업캐스팅
	// Employee emp = SalesMan; // 자동 업캐스팅
	// Employee emp = Temp;        // 자동 업캐스팅
	private static void printEmpPay( Employee emp ) {
		// R/S/T 어떤 객체인지 파악을 해서 코딩... : 그 객체가 어떤 클래스 타입의 인스턴스 인지 확인하는 연산자  instanceof 연산자
		// (주의할점)  true/false  객체 instanceof  클래스타입  연산자 
		// 1. if~else if 문
		// 2. 자식 클래스 먼저 체크한다. 
		if(  emp instanceof  SalesMan  ) {
			System.out.println("영업직 사원");
			// 다운캐스팅
			SalesMan s = (SalesMan) emp;
			// 코딩처리..
			// :
		}
		else if(  emp instanceof  Regular  ) System.out.println("정규직 사원");
		else if(  emp instanceof  Temp  ) System.out.println("임시직 사원");
		
		 System.out.println("> 사원급여 : " + emp.getPay());  // 다형성
	}
	
	// 오버로딩
	/*
	private static void printEmpPay(Regular emp) {
		 System.out.println("> 정규직 사원급여 : " + emp.getPay());
	}
	
	private static void printEmpPay(SalesMan emp) {
		 System.out.println("> 영업직 사원급여 : " + emp.getPay());
	}
	
	private static void printEmpPay(Temp emp) {
		 System.out.println("> 임시직 사원급여 : " + emp.getPay());
	}
	:
	:
   */
} // class









