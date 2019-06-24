package sort;

public class BubbleSort implements Sort {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                swap(arr,j,j+1);
            }
        }
    }

    private <T extends Comparable<? super T>> void swap(T[] arr, int i, int maxIndex) {
        T temp=arr[i];
        arr[i]=arr[maxIndex];
        arr[maxIndex]=temp;
    }

}
