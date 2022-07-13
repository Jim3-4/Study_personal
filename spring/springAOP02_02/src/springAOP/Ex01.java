package springAOP;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

import aop.Calculator;
import aop.CalculatorImpl;

public class Ex01 {
public static void main(String[] args) {
	String  resourceLocations="applicationContext.xml";
	GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(resourceLocations);
	/*
	 * 예외발생!! Exception in thread "main"
	 * org.springframework.beans.factory.BeanCreationException: Error creating bean
	 * with name 'calcProxy' defined in class path resource
	 * [applicationContext.xml]: Cannot resolve reference to bean 'calc' while
	 * setting bean property 'target'; nested exception is
	 * org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean
	 * named 'calc' is defined
	 * 
	 */
	//Calculator calc=ctx.getBean("calc", CalculatorImpl.class);
	Calculator calc=ctx.getBean("calcProxy", Calculator.class);
	System.out.println(calc.add(4, 2));
	
	//BeforeAdvice 생성추가 - aop.advice.logPrintBefore 클래스추가 
	//AfterAdvice 생성추가 - aop.advice.logPrintAfter
	
}
}
