package spring.aop.demo;

/**
 * FileName: RoleInterceptor
 * Author:   haichaoyang3
 * Date:     2020/6/28 14:09
 * Description:
 * History:
 * since: 1.0.0
 */

public class RoleInterceptor implements Interceptor {
    @Override
    public void before(Object object) {
        System.out.println("准备打印角色信息");
    }

    @Override
    public void after(Object object) {
        System.out.println("已经完成角色信息的打印处理");
    }

    @Override
    public void afterReturning(Object object) {
        System.out.println("刚刚完成打印功能，一切正常");
    }

    @Override
    public void afterThrowing(Object object) {
        System.out.println("打印功能异常了，查看一下角色对象为空了吗？");
    }

//TODO
}
