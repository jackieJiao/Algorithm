package sort;

/*
* 插入排序
*
* 相比O（n*n）得selection排序。
* */
public class InsertionSortPlus implements Sort{
    public <T extends Comparable<? super T>> void sort(T[] arr){
        //from arr[1]个开始，插入前面已排序
        for (int i = 1; i < arr.length; i++) {
            T temp=arr[i];
            int j;
            for (j=i;j>0&&temp.compareTo(arr[j-1])<0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=temp;

        }
    }
    private <T extends Comparable<? super T>> void swap(T[] arr, int i, int maxIndex) {
        T temp=arr[i];
        arr[i]=arr[maxIndex];
        arr[maxIndex]=temp;
    }


}
