package sort;

import utils.Utils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr= Utils.generateIntArray(10000);
        Integer[] arr2=new Integer[arr.length];
        Integer[] arr3=new Integer[arr.length];
        Integer[] arr4=new Integer[arr.length];
        Integer[] arr5=new Integer[arr.length];
        System.arraycopy(arr,0,arr2,0,arr.length);
        System.arraycopy(arr,0,arr3,0,arr.length);
        System.arraycopy(arr,0,arr4,0,arr.length);
        System.arraycopy(arr,0,arr5,0,arr.length);

        //testSort(arr,new SelectionSort());
       // testSort(arr2,new InsertionSort());
        //testSort(arr3,new InsertionSortPlus());
        testSort(arr5,new MergeSort());
        testSort(arr4,new MergeSortPlusWithInsertion());


    }

    private static void testSort(Integer[] arr, Sort sorter) {
        long start=System.nanoTime();
        System.out.println(Arrays.toString(arr));
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(sorter.getClass().getName()+"Time:"+(System.nanoTime()-start)/1000000);
    }
}
