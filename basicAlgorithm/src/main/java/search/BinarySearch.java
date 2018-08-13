package search;

import java.util.Arrays;
import java.util.List;
/*
* 如果存在n这个数字，return 它在list中的下标值
* 如果不存在，return null
*
* */
public class BinarySearch {
    static List<Integer> list;
    int n;

    public static void main(String[] args) {
        list= Arrays.asList(new Integer[]{0,1,2,3,5});
        System.out.println(bswithRecursion(0,4,6));

    }

    /*
    * recursion
    * */
    public static String bswithRecursion(int a,int b,int n) {
        if (b-a<=1){
            return (n==list.get(b))?Integer.toString(b):"null";
        }else {

            int tmp = (a + b) / 2;
            if (n > list.get(tmp))
                return bswithRecursion(tmp + 1, b, n);
            else if (n < list.get(tmp))
                return bswithRecursion(a, tmp - 1, n);
            else
                return Integer.toString(tmp);

        }



    }
}
