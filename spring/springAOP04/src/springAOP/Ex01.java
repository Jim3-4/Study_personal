package springAOP;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aop.Calculator;

public class Ex01 {
public static void main(String[] args) {
    String resourceLocations = "applicationContext.xml";
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations );
    Calculator calc = (Calculator) ctx.getBean("calc");

    System.out.println(calc.add(4, 2));
//    System.out.println(calc.sub(4, 2));
//    System.out.println(calc.mult(4, 2));
//    System.out.println(calc.div(4, 2));
    System.out.println("= END =");
	
}
}
