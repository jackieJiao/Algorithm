package utils;

import LinkedList.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static void printLinkedlist(Node headoflist) {
        while(headoflist.getNext()!=null){
            System.out.print(headoflist.getValue());
            headoflist=headoflist.getNext();
        }
        System.out.print(headoflist.getValue());
    }
    public static void main(String[] args) {
        Integer a[]=generateIntArray(10);
        for (int i=0;i< a.length;i++) System.out.println(a[i]);
    }
    public static  Integer [] generateIntArray(int l){
        Random r=new Random();
        //int i=r.nextInt(20);
        Integer [] a= new Integer[l];
        for(int i=0;i<a.length;i++){
            a[i]=r.nextInt(10000);
        }


        return a;
    }
    public static List<String> generateStringList(int i){
        List<String> list=new ArrayList<String>();
        for (int j=0;j<i;j++){
            list.add(String.valueOf(j));
        }
        return list;

    }
}
