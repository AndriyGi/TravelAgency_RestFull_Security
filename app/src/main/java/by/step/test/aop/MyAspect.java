package by.step.test.aop;

import by.step.test.dao.entity.Human;
import by.step.test.dto.HumanDto;
import by.step.test.exception.ExcHumanIsPresent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {
    @Around("Pointcuts.allSetMethods()")
    public Object aroundSaveAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Human human = null;
        log.info(" adding the METHOD SIGNATURE -------");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info(" checking - METHOD  SIGNATURE------ ");
        if (methodSignature.getName().equals("save")) {
            log.info(" GETTING  ARGUMENTS------ ");
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof Human) {
                    log.info(" INSTANCE--- ");
                    human = (Human) arg;
                }
            }
        }
        Object result = null;
        log.info(" PROCEED -- EXECUTE  ---- ");
        result = joinPoint.proceed();
        log.info(" RETURN  RESULT---- OBJECT ");
        return result;
    }

    @Around("Pointcuts.allGetMethods()")
    public Object aroundFindHumanByIdAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Human human = new Human();
        log.info(" adding the METHOD SIGNATURE ");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info(" checking - METHOD SIGNATURE NAME  - equals(findById) ??? ");
        if (methodSignature.getName().equals("findById")) {
            log.info(" - jointPoint - getting Arguments from - findById");
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof Human) {
                    log.info(" - EXTRACTING signature of Human class");
                    human = (Human) arg;

                }
            }
        }
        Object result = null;
        log.info(" PROCEED -- EXECUTE  ---- ");
        result = joinPoint.proceed();
        log.info(" RETURN  RESULT---- OBJECT ");
        return result;
    }


}
