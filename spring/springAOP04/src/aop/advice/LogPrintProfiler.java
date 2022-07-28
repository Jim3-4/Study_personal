package aop.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//before ,after,around advice를 대신할 공통 기능을 구현할 클래스 
@Component("logPrintProfiler")
public class LogPrintProfiler {

    // 1. Around Advice - 처리시간을 로그로 기록 (출력)
    public Object trace(ProceedingJoinPoint joinPoint) throws Exception {
        String signature = joinPoint.getSignature().toShortString();

        Log log = LogFactory.getLog(this.getClass());
        StopWatch sw = new StopWatch();
        log.info("> " + signature + "() start.");
        sw.start();

        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            sw.stop();
            log.info("> " + signature + "() stop.");
            log.info("> " + signature + "() 처리시간: " + sw.getTotalTimeMillis() + "ms");
        }
        return result;
    }
//before과 after는 매개변수를 JoinPoint joinpoint 
//함수명은 마음대로
    public void before(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        Log log = LogFactory.getLog(this.getClass());
        log.info(">>> " + methodName + "() before advice.");
    }

    public void afterFinally(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        Log log = LogFactory.getLog(this.getClass());
        log.info(">>> " + methodName + "() afterFinally advice.");
    }
}