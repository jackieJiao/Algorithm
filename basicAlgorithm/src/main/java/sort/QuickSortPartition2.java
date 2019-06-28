package sort;

import java.util.Random;

public class QuickSortPartition2 implements Sort{


    /* 方法入口*/
    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr) {
        quicksort(arr,0,arr.length-1);
    }

    /* 递归快排过程*/
    private <T extends Comparable<? super T>> void quicksort(T[] arr, int l, int r) {
        //== 会产生数组越界!!!!!!! 在（p+1,r）的地方越界
        /*if (l>=r)
            return;*/
        /* 优化点：当数组小于15时候，采用更简单的排序算法 */
        if (r-l<=15){
            for (int i = l+1; i < r+1; i++) {
                for (int j=i;j>l&&arr[j].compareTo(arr[j-1])<0;j--){
                    swap(arr,j,j-1);
                }
            }
            return;
        }


        /*关键步骤： partition操作。把数组分为两部分。P的位置为中间数所在的位置，左边小于P 右边大于P*/
        int p=partition(arr,l,r);
        quicksort(arr,l,p-1);
        quicksort(arr,p+1,r);
    }

    //partition操作，返回索引值P。
    private <T extends Comparable<? super T>> int partition(T[] arr, int l, int r) {
        //T temp=arr[l];//选第一个元素为比较元素。
        /* 优化点：temp不能为第一个元素。在一个近乎有序的数组中，有可能退化为n*n的复杂度。
        *  随机数据randomInt和l，交换。这样的好处是下面的逻辑不用修改。
        * */
        Random random = new Random();
        int randomInt = random.nextInt(r);
        swap(arr,l,randomInt%(r-l+1)+l);
        T temp=arr[l];
        /*
        * partition2 优化：
        *
        * 解决了重复元素过多情况，左右两边不平衡的问题。
        *
        * 这样和temp相同的元素，会均匀的分布在左右两边。
        * */
        //arr[l+1...i)<=temp  arr(j...r]>=temp;
        int i=l+1,j=r;
        while(true){
            while(i<=r && arr[i].compareTo(temp)<0) i++;
            while(j>=l+1 && arr[j].compareTo(temp)>0) j--;
            if (i>j) break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;


    }



    private <T extends Comparable<? super T>> void swap(T[] arr, int i, int maxIndex) {
        T temp=arr[i];
        arr[i]=arr[maxIndex];
        arr[maxIndex]=temp;
    }
}
