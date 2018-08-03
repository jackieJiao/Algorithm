package combinations;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
/*
* 生成所有组合
* */

public class Combinations {
    private static List<String> tmp=new ArrayList<String>();

    public static void main(String[] args) {
        List<String> list = Utils.generateStringList(5);
        int n=2;

        combination(tmp,list,n);
    }
    /*
    * 递归方法
    * */
    private static void combination(List<String> tmp,List<String> list, int n) {
        if(0==n){
            for (String s :
                    tmp) {
                System.out.print(s);
            }
            System.out.println();
            return;
        }
        if(list.size()<n)return;
        if(list.size()==n){
            for (String s :
                    tmp) {
                System.out.print(s);
            }
            for (String s :
                    list) {
                System.out.print(s);
            }
            System.out.println();
            return;
        }




        tmp.add(list.get(0));
        //contains 0
        combination(tmp,list.subList(1,list.size()),n-1);

        //not contains 0
        tmp.remove(tmp.size()-1);
        combination(tmp,list.subList(1,list.size()),n);
    }
}
