package sort;

import utils.Utils;

import java.util.Arrays;

/*
* 插入排序
*
* 1、相比O（n*n）得selection排序。理论性能要好。
* 但是需要一定的改造。
*
* 2、在基本有序得数组情况下，效率极其高。
* 3、shell sort是对insertionSort得优化。
*
* */
public class InsertionSort implements Sort{
    public <T extends Comparable<? super T>> void sort(T[] arr){
        //from arr[1]个开始，插入前面已排序
        for (int i = 1; i < arr.length; i++) {
            for (int j=i;j>0&&arr[j].compareTo(arr[j-1])<0;j--){
                swap(arr,j,j-1);
            }
        }
    }
    private <T extends Comparable<? super T>> void swap(T[] arr, int i, int maxIndex) {
        T temp=arr[i];
        arr[i]=arr[maxIndex];
        arr[maxIndex]=temp;
    }


}
