package sort;

public class QuickSort3Way implements Sort{
    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        quicksort(arr,0,arr.length-1);
    }

    private <T extends Comparable<? super T>> void quicksort(T[] arr, int l, int r) {
        if (l>=r)
            return;
        /*int p=partition(arr,l,r);*/
        int lt=l;
        int gt=r+1;
        int i=l+1;
        T temp=arr[l];
        while(i<gt){
            if (arr[i].compareTo(temp)<0){
                swap(arr,i,lt+1);
                lt++;
                i++;
            }else if (arr[i].compareTo(temp)>0){
                swap(arr,i,gt-1);
                gt--;
            }else {i++;}
        }
        swap(arr,l,lt);

        //!!! 在这里直接递归，注意递归的范围
        quicksort(arr,l,lt-1);
        quicksort(arr,gt,r);
    }


    private <T extends Comparable<? super T>> void swap(T[] arr, int i, int maxIndex) {
        T temp=arr[i];
        arr[i]=arr[maxIndex];
        arr[maxIndex]=temp;
    }
}
