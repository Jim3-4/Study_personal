package springAOP;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

import aop.Calculator;
import aop.CalculatorImpl;

public class Ex01 {
public static void main(String[] args) {
	String  resourceLocations="applicationContext.xml";
	GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(resourceLocations);

	//Calculator calc=ctx.getBean("calc", CalculatorImpl.class);
	Calculator calc=ctx.getBean("calcProxy", Calculator.class);
	System.out.println(calc.add(4, 2));
	
	//BeforeAdvice 생성추가 - aop.advice.logPrintBefore 클래스추가 
	//AfterAdvice 생성추가 - aop.advice.logPrintAfter
	
}
}
