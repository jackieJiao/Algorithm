package sort;

public class ShellSort {
    /*
    * 1.迭代缩减序列，默认为N/2
    * 2.顺序迭代一次，对每一个迭代序列的值，进行insertionSort
    *
    * */
    public static <AnyType extends Comparable<? super AnyType>>
    void sort(AnyType [] a){

        int j;
        //1
        for(int gap=a.length/2;gap>0;gap/=2){
           //从i=gap开始
           for(int i=gap;i<a.length;i++){
               //开始对a[i],在缩减序列上插入排序
               AnyType tmp = a[i];
               for(j=i;j>=gap&&tmp.compareTo(a[j-gap])<0;j-=gap)
                   a[j]=a[j-gap];
               a[j]=tmp;

           }
        }


    }
}
