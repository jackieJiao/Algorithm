package utils;

import java.util.Random;

public class Utils {
    public static void main(String[] args) {
        Integer a[]=generateIntArray();
        for (int i=0;i< a.length;i++) System.out.println(a[i]);
    }
    public static  Integer [] generateIntArray(){
        Random r=new Random();
        //int i=r.nextInt(20);
        Integer [] a= new Integer[10];
        for(int i=0;i<a.length;i++){
            a[i]=r.nextInt(100);
        }


        return a;
    }
}
