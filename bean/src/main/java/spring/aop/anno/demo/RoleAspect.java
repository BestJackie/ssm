package spring.aop.anno.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * FileName: RoleAspect
 * Author:   haichaoyang3
 * Date:     2020/6/28 16:03
 * Description:
 * History:
 * since: 1.0.0
 */
@Aspect
public class RoleAspect {

    @DeclareParents(value = "spring.aop.anno.demo.RoleServiceImpl+",
    defaultImpl = RoleVerifierImpl.class)
    public RoleVerifier roleVerifier;


    @Pointcut("execution(* spring.aop.anno.demo.RoleServiceImpl.printRole(..))")
    public void print() {

    }

    //    @Before("execution(*spring.aop.aspect.anno.RoleServiceImpl.printRole(..))")
    @Before("print()")
    public void before() {
        System.out.println("before...........");
    }

    //    @After("execution(* spring.aop.aspect.anno.RoleServiceImpl.printRole(..))")
    @After("print()")
    public void after() {
        System.out.println("after...........");
    }

    //    @AfterReturning("execution(* spring.aop.aspect.anno.RoleServiceImpl.printRole(..))")
    @AfterReturning("print()")
    public void afterReturning() {
        System.out.println("afterReturning...........");
    }

    //    @AfterThrowing("execution(* spring.aop.aspect.anno.RoleServiceImpl.printRole(..))")
    @AfterThrowing("print()")
    public void afterThrowing() {
        System.out.println("afterThrowing...........");
    }

    @Around("print()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("=================before==================");
        boolean flag = false;
        try {
            proceedingJoinPoint.proceed();
        }catch (Throwable throwable) {
            flag = true;
            throwable.printStackTrace();
        }
        System.out.println("==================after====================");
        if (flag){
            System.out.println("============环绕通知抛出异常=====================");
        }
    }
}
