package proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class AdminServiceDYProxy {
    private Object target;
    private InvocationHandler invocationHandler;

    public AdminServiceDYProxy(Object target, InvocationHandler invocationHandler) {
        this.target = target;
        this.invocationHandler = invocationHandler;
    }

    public Object getPersonProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),invocationHandler);
    }


    public static void main(String[] args) {
        /*// 方法一
        System.out.println("============ 方法一 ==============");
        //targer object
        AdminService adminService = new AdminServiceImpl();
        System.out.println("代理的目标对象：" + adminService.getClass());

        AdminServiceDYProxyInvocationHandler adminServiceDYProxyInvocationHandler=new AdminServiceDYProxyInvocationHandler(adminService);

        AdminService proxy = (AdminService) new AdminServiceDYProxy(adminService, adminServiceDYProxyInvocationHandler).getPersonProxy();
        System.out.println("代理对象："+proxy.getClass());

        Object obj = proxy.find();
        System.out.println("find 返回的对象："+obj.getClass());
        proxy.update();

        System.out.println("---------------");*/
        //方法二

        AdminServiceImpl target = new AdminServiceImpl();
        AdminServiceDYProxyInvocationHandler invoc = new AdminServiceDYProxyInvocationHandler(target);
        AdminService proxy = (AdminService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invoc);

        System.out.println("代理对象："+proxy.getClass());

        Object obj = proxy.find();
        System.out.println("find 返回的对象："+obj.getClass());
        proxy.update();


    }
}
