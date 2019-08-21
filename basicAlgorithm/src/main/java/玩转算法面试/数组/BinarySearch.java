package 玩转算法面试.数组;

import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BinarySearch<T extends Comparable<? super T>> {
    public int bSearch(T[] arr,int n, T target){
        //两个边界
//        [l,r]
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if (arr[mid].compareTo(target)==0)
                return mid;
            if (arr[mid].compareTo(target)>0)
                r=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
//        Integer[] arr={1,2,3,4,5,6};
//        System.out.println(new BinarySearch<Integer>().bSearch(arr, 6, Integer.valueOf(2)));


        MessageDigest md5 = MessageDigest.getInstance("MD5");
        System.out.println(md5);

    }
}
