package by.step.test.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* by.step.test.service.impl.HumanServiceImpl.find*(..))")
    public  void  allGetMethods(){}

    @Pointcut("execution(* by.step.test.service.impl.HumanServiceImpl.save*(..))")
    public  void  allSetMethods(){}

}
