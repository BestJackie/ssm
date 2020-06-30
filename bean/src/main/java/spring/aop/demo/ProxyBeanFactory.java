package spring.aop.demo;

/**
 * FileName: ProxyBeanFactory
 * Author:   haichaoyang3
 * Date:     2020/6/28 14:04
 * Description:
 * History:
 * since: 1.0.0
 */

public class ProxyBeanFactory {
    //TODO
    public static <T> T getBean(T obj,Interceptor interceptor){
        return (T) ProxyBeanUtil.getBean(obj,interceptor);
    }
}
