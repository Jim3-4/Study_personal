package springDI;

import org.springframework.context.support.GenericXmlApplicationContext;

import aop.Calculator;
import aop.CalculatorImpl;

public class Ex01 {
public static void main(String[] args) {
	String  resourceLocations="applicationContext.xml";
	GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(resourceLocations);

	//Calculator calc=ctx.getBean("calc", CalculatorImpl.class);
	Calculator calc=ctx.getBean("calcProxy", CalculatorImpl.class);
	System.out.println(calc.add(4, 2));
}
}
