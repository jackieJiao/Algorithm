package sort;

import utils.Utils;

import java.util.Arrays;

public class MergeSort{

    public <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr,0,arr.length-1);
    }

    private <T extends Comparable<T>> void sort(T[] arr, int l, int r) {

        //finalConditon
        if (l==r)
            return;

        int mid=l+(r-l)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);

        //左半部分、右半部分分别排序好。然后合并
        merge(arr,l,mid,r);
    }
    private <T extends Comparable<T>>  void merge(T[] arr, int l, int mid, int r) {
        /* 复制一份数组，设置三个索引位置。logN merge完成*/
        int i=l;
        int j=mid+1;
        T[] arr1=Arrays.copyOf(arr,arr.length);
        /* */
        //T[] arr1= (T[])new Object[arr.length];
        //System.arraycopy(arr,0,arr1,0,arr.length);

        for (int k = l; k <=r; k++) {
            if (arr1[i].compareTo(arr1[j])<0&&i<=mid)
                arr[k]=arr1[i++];
            else
                arr[k]=arr1[j++];
        }

    }

    public static void main(String[] args) {
        Integer[] arr= Utils.generateIntArray(10);
        System.out.println(Arrays.toString(arr)
        );
        new MergeSort().sort(arr);
        System.out.println(Arrays.toString(arr)
        );

    }
}
