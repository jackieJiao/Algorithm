package sort;

import utils.Utils;

import java.util.Arrays;

public class SelectionSort implements Sort{
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j])>0)
                    //大到小排序
                    minIndex=j;
            }
            swap(arr,i,minIndex);
        }
    }

    private <T extends Comparable<? super T>> void swap(T[] arr, int i, int maxIndex) {
        T temp=arr[i];
        arr[i]=arr[maxIndex];
        arr[maxIndex]=temp;
    }

}
