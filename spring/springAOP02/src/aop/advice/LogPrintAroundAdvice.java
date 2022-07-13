package aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// com.springsource.org.aopalliance-1.0.0.jar  추가
// MethodInterceptor 인터페이스를 구현해야 된다. - AroundAdvice
public class LogPrintAroundAdvice implements MethodInterceptor{

   // method  == add()/ sub()/ mult()/ div()
   @Override
   //호출한 메소드가 인자값으로 들어온다. 
   public Object invoke(MethodInvocation method) throws Throwable {
       String methodName =    method.getMethod().getName();
       
       // 스프링 에서 제공하는 StopWatch 클래스 -> 로그 처리.
       Log log = LogFactory.getLog(this.getClass());
       StopWatch sw  = new StopWatch();
log.info("> " + methodName + "() start.");       
       sw.start();
       Object result  = method.proceed(); //핵심기능 (add(), sub(),,,) 
       //메소드가 실행되고 반환되는 값을 Object로 받음 
       sw.stop();
log.info("> " + methodName + "() stop.");
log.info("> " + methodName + "() 처리 시간 :  " + sw.getTotalTimeMillis() +"ms");       
       // 로그 처리
      return result;
   }

} // class







