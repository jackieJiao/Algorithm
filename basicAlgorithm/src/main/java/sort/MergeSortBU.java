package sort;


import utils.Utils;

import java.util.Arrays;
/*
* 自底向上的归并排序，应用场景是非数组情况。
*
* 原理，从头到尾2个的排序，然后4个排序，八个排序。。。
*
* */
public class MergeSortBU implements Sort{


    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        for (int sz=1;sz<=arr.length;sz=sz*2){
            //按顺序把sz个元素分别排序。
            // 处理两处边界越界问题。1、i+sz-1 要小于n-1;2、(i+sz+sz-1)<n-1;
            for (int i=0;i<arr.length;i=i+sz+sz-1){
                merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,arr.length-1));
            }
        }
    }

    private <T extends Comparable<? super T>>  void merge(T[] arr, int l, int mid, int r) {
        /* 复制一份数组，设置三个索引位置。logN merge完成*/
        int i=l;
        int j=mid+1;
        T[] arr1=Arrays.copyOf(arr,arr.length);
        for (int k = l; k <=r; k++) {
            if (i>mid)
                arr[k]=arr1[j++];
            else if (j>r)
                arr[k]=arr1[i++];
            //以上为处理便捷条件
            else if (arr1[i].compareTo(arr1[j])<0)
                arr[k]=arr1[i++];
            else
                arr[k]=arr1[j++];
        }

    }

    public static void main(String[] args) {
        Integer[] arr= Utils.generateIntArray(10);
        System.out.println(Arrays.toString(arr)
        );
        new MergeSortBU().sort(arr);
        System.out.println(Arrays.toString(arr)
        );

    }


}
