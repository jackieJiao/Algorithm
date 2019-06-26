package sort;

public class QuickSort implements Sort{
    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        quicksort(arr,0,arr.length-1);
    }

    private <T extends Comparable<? super T>> void quicksort(T[] arr, int l, int r) {
        if (l==r)
            return;
        int p=partition(arr,l,r);
        quicksort(arr,l,p);
        quicksort(arr,p+1,r);
    }
    // P的位置为中间数所在的位置，左边小于P 右边大于P
    private <T extends Comparable<? super T>> int partition(T[] arr, int l, int r) {
        return 0;
    }
}
