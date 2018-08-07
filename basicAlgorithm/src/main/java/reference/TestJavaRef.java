package reference;

import LinkedList.Node;


/*
*
* Java引用规则
* 1.引用和实际对象区分开
* 2.改变引用会改变实际对象
* 3.改变引用的指向，不会改变实际对象，实际对象会被GC回收
*
*
* */
public class TestJavaRef {
    public static void main(String[] args) {
        Node head=new Node("2");
        Node pre=head;
        System.out.println(pre.getValue());
        System.out.println(head.getValue());

        System.out.println("change pre ref");
        pre=new Node("3");
        System.out.println(pre.getValue());
        System.out.println(head.getValue());




        int origin=2;
        int ref=origin;
        origin=3;
        System.out.println(origin);
        System.out.println(ref);

    }
}
