package spring.aop.demo;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * FileName: ProxyBeanUtil
 * Author:   haichaoyang3
 * Date:     2020/6/28 14:17
 * Description:
 * History:
 * since: 1.0.0
 */

public class ProxyBeanUtil implements InvocationHandler {

    private Object object;
    private Interceptor interceptor;

    public static Object getBean(Object obj, Interceptor interceptor) {
        ProxyBeanUtil _this = new ProxyBeanUtil();
        _this.object = obj;
        _this.interceptor = interceptor;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), _this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retObject = null;
        boolean exceptionFlag = false;
        interceptor.before(object);
        try {
            retObject = method.invoke(object, args);
        }catch (Exception e){
            exceptionFlag = true;
        }finally {
            interceptor.after(object);
        }
        if (exceptionFlag){
            interceptor.afterThrowing(object);
        }else {
            interceptor.afterReturning(object);
        }
        return retObject;
    }

    //TODO
}
