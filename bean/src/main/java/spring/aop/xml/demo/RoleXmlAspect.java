package spring.aop.xml.demo;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * FileName: RoleXmlAspect
 * Author:   haichaoyang3
 * Date:     2020/6/29 14:57
 * Description:
 * History:
 * since: 1.0.0
 */

public class RoleXmlAspect {
    public void before(){
        System.out.println("++++++++++++++++brfore++++++++++++++++=");
    }
    public void after(){
        System.out.println("++++++++++++++++after++++++++++++++++=");
    }
    public void afterReturning(){
        System.out.println("++++++++++++++++afterReturning++++++++++++++++=");
    }
    public void afterThrowing(){
        System.out.println("++++++++++++++++afterThrowing++++++++++++++++=");
    }

    public void around(ProceedingJoinPoint pj){
        System.out.println("+=================before==================+");
        try {
            pj.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("++++++++++++++++回调原流程异常+++++++++++++++++++");
        }
        System.out.println("+++++++++++++++++after+++++++++++++++++++=");
    }
}
