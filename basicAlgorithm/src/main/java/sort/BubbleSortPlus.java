package sort;

public class BubbleSortPlus implements Sort {
    int exCount=0;
    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            //是否有交换
            Boolean ex=false;

            for (int j = 0; j < arr.length - 1-i; j++) {
                if (arr[j].compareTo(arr[j+1])>0){
                    swap(arr,j,j+1);
                    ex=true;
                }

            }
            exCount++;
            if (!ex)
                break;
        }
        System.out.println("plus交换次数"+exCount);
    }

    private <T extends Comparable<? super T>> void swap(T[] arr, int i, int maxIndex) {
        T temp=arr[i];
        arr[i]=arr[maxIndex];
        arr[maxIndex]=temp;
    }

}
