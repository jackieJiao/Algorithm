package thinkinginstring;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class Person{
    String name;
}

public class ReferenceTricks {

    public static void main(String[] args) {
        testPhantom();

    }

    private static void testPhantom() {
        Person p1=new Person();
        ReferenceQueue<Person> refQueue = new ReferenceQueue<Person>();
        PhantomReference pr=new PhantomReference(p1,refQueue);
        System.out.println(pr.get());
        System.out.println(refQueue.poll());
        p1=null;
        System.gc();
        System.out.println(pr.get());
        System.out.println(refQueue.poll());
        System.out.println(refQueue.poll());


    }

    private static void test1() {
        Person p1=new Person();
        ReferenceQueue<Person> refQueue = new ReferenceQueue<Person>();
        WeakReference wr=new WeakReference(p1,refQueue);
        System.out.println(wr.get());
        System.out.println(refQueue.poll());
        p1=null;
        System.gc();
        System.out.println("after gc()");
        System.out.println(wr.get());
        System.out.println(refQueue.poll());
    }

    private static void change(Person p) {
        p.name="liu";
    }

    private static void
    changeReference(ReferenceTricks r) {
        r = new ReferenceTricks();
        r.i = 5;
        System.out.println
                ("In changeReference: " + r.i);
    }

    private static void
    changeInteger(ReferenceTricks r) {
        r.i = 5;
        System.out.println
                ("In changeInteger:" + r.i);
    }

    public int i;
}