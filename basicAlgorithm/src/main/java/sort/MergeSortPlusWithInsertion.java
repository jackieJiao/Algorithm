package sort;


import utils.Utils;

import java.util.Arrays;

public class MergeSortPlusWithInsertion implements Sort{


    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr,0,arr.length-1);
    }
    private <T extends Comparable<? super T>> void sort(T[] arr, int l, int r) {

        //finalConditon
        /*if (l==r)
            return;*/
        if ((r-l)<=15){
            for (int i = l+1; i < r+1; i++) {
                for (int j=i;j>l&&arr[j].compareTo(arr[j-1])<0;j--){
                    swap(arr,j,j-1);
                }
            }
            return;
        }


        int mid=l+(r-l)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);

        //左半部分、右半部分分别排序好。然后合并
        merge(arr,l,mid,r);
    }

    private <T extends Comparable<? super T>> void swap(T[] arr, int i, int maxIndex) {
        T temp=arr[i];
        arr[i]=arr[maxIndex];
        arr[maxIndex]=temp;
    }
    private <T extends Comparable<? super T>>  void merge(T[] arr, int l, int mid, int r) {
        /* 复制一份数组，设置三个索引位置。logN merge完成*/
        int i=l;
        int j=mid+1;
        T[] arr1=Arrays.copyOf(arr,arr.length);

        /* doesnt work because Object cant cast to Comparable,T is a Comparable */ //this way works:T[] arr1=(T[]) Array.newInstance(arr.getClass().getComponentType(),arr.length);

        //T[] arr1= (T[])new Object[arr.length];
       // System.arraycopy(arr,0,arr1,0,arr.length);

        for (int k = l; k <=r; k++) {
            if (i>mid){
                arr[k]=arr1[j++];
            }
            else if (j>r)
                arr[k]=arr1[i++];

            else if (arr1[i].compareTo(arr1[j])<0)
                arr[k]=arr1[i++];
            else
                arr[k]=arr1[j++];
        }

    }

    public static void main(String[] args) {
        Integer[] arr= Utils.generateIntArray(1000);
        System.out.println(Arrays.toString(arr)
        );
        new MergeSortPlusWithInsertion().sort(arr);
        System.out.println(Arrays.toString(arr)
        );

    }


}
