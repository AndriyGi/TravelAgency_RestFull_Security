//package by.step.test.aop;
//
//import by.step.test.dto.HumanDto;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import java.util.Arrays;
//
////---------- A O P ---------------------
//
//@Component
//@Aspect
//public class LogAspect {
//
//
//    @Pointcut("execution (public * by.step.test.service.impl.HumanServiceImpl.findById())")
//    public void beforeServiceMethodInvocation(JoinPoint jp) {
//        System.out.println("Invocation of method" + jp.getSignature());
//    }
//
//    @Before("beforeServiceMethodInvocation(jp)")
//    public void findAll(JoinPoint jp) {
//        Arrays.stream(jp.getArgs()).forEach(o -> {
//        });
//    }
//
//}
