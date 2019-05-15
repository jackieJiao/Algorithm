package jvm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Helloworld {
    public Helloworld() {
    }

    public String name="jaio";
    private String password="123456789";

    public void getname(){}
    private void getpass(){
        System.out.println("pass");
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        //三种获取class对象方法
        Class<Helloworld> helloworldClass = Helloworld.class;
        //Class h1= Class.forName("Helloworld");
        Class h2=new Helloworld().getClass();

        //反射的方法
        //1，获得成员变量
        //获得本类所有private public方法
        System.out.println(Arrays.toString(helloworldClass.getDeclaredMethods()));
        //获得父类所有public方法
        System.out.println(Arrays.toString(helloworldClass.getMethods()));
        //2.构造instance,此方法要求类具有一个无参构造器
        Helloworld h=helloworldClass.newInstance();

        //调用方法invoke 访问字段值
        Helloworld hobj=new Helloworld();
        System.out.println(helloworldClass.getDeclaredField("password").get(hobj));
        //Method.invoke(Object)
        Method m=helloworldClass.getDeclaredMethod("getpass");
        try {
            m.invoke(hobj);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }




    }
}
