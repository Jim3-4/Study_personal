package springAOP;

import aop.Calculator;
import aop.CalculatorImpl;

public class Ex01 {
public static void main(String[] args) {
	System.out.println("홍길동");
	/*
	 * AOP = 관점지향적인 프로그래밍 기법
	 * 
	 * 2가지관점
	 * 
	 * 1) 공통부분: 인증처리, 트랜잭션 ,보안 부분 [공통적인 부분을 cross-cutting concern]
	 * 
	 * 2)본연의 업무 (로직부분) => 글쓰기, 글수정 ,글삭제 부분 [핵심 관심 사항 core concern]
	 * 
	 * 글쓰기 /write.do/ writeHandler /세션인증 null-> 로그인 요청 이동
	 * 
	 * 글수정 /edit.do/ EditHandler /세션인증 null-> 로그인 요청 이동 글삭제 /delete.do/DeleteHandler
	 * /세션인증 null-> 로그인 요청 이동
	 * 
	 * +++ 반드시 알아야할 AOP 용어 +++ (암기)
Aspect: 여러 객체에 공통으로 적용되는 기능 (공통기능)
Advice: 공통기능을 핵심기능에 [언제] 적용할지를 정의 - 전+후, 전, 후
Weaving: advice 를 핵심로직코드에 적용 (삽입) 하는 것.
Joinpoint: Advice 를 적용 (삽입) 가능하는 지점- 예) add() 메서드 호출
Pointcut: Advice 를 실제 적용한 지점.
스프링에서는 정규표현식, [AspectJ문법] +++ 을 이용해서 Pointcut 을 설정할 수 있다.

세가지의 Weaving 방식
컴파일 시
클래스 로딩 시
런타임 시
	프록시 (proxy) 기반으로 AOP 지원하기 때문에
	Joinpoint 를 메서드만 사용할 수 있다.
	
	
스프링 AOP 구현하는 3가지 방법
스프링 API 이용한 AOP 구현 X
XML 스키마 기반의 POJO 클래스를 이용한 AOP 구현 O - xml 파일
AspectJ 에서 정의한 @Aspect 어노테이션 기반의 AOP 구현 O - @Aspect 어노테이션
Advice 종류
Before Advice
Around Advice
After Advice, After Throwing Advice, After Returning Advice
	 */
	
	Calculator calc=new CalculatorImpl();
	System.out.println(calc.add(4, 2));
	System.out.println(calc.sub(4, 2));
	System.out.println(calc.mult(4, 2));
	System.out.println(calc.div(4, 2));
	System.out.println("end");
}
}
