package proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AdminServiceDYProxyInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public AdminServiceDYProxyInvocationHandler(Object target) {
        this.target = target;
    }
    //之前代理对象必须实现接口所有的方法。现在不需要

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("判断用户是否有权限进行操作");
        Object obj = method.invoke(target);
        System.out.println("记录用户执行操作的用户信息、更改内容和时间等");
        return obj;
    }
}
