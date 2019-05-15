package jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

public class Foo {
    private static void bar(Object o){
        System.out.println("barMethod in");

    }
    public static MethodHandles.Lookup lookup(){
        return MethodHandles.lookup();
    }


    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup l=Foo.lookup();
        Method m =Foo.class.getDeclaredMethod("bar",Object.class);
        MethodHandle mh=l.unreflect(m);

        mh.invoke("hello");
        //mh.invokeExact((Object)"helloW");
    }
}
