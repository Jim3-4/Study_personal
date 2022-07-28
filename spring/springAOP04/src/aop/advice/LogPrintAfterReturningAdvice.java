package aop.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;
//@Component("calc")
//핵심기능이 수행후에  예외가 발생하지 않았을경우 
public class LogPrintAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning
	(Object returnValue,
			Method method,  //add()
			Object[] args, //매개변수
			Object target) throws Throwable {

		String methodName=method.getName();
		Log log=LogFactory.getLog(this.getClass());
		//호출되는 지 확인만 해보는 예제 
		log.info(">>>"+methodName+"() logPrintAfterReturningAdvice호출됨 :"+ returnValue);
	}

}
