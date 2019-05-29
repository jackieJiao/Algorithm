package recursion;
/*
* 递归思路：
* 1，求解最基本问题
* 2，原问题转化为更小的问题（规模缩小）
* */
public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }
    //计算arr[l...n)这个区间内的和

    private static int sum(int[] arr, int l) {
        if(l==arr.length)
            return 0;

        return arr[l]+sum(arr,l+1);

    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(sum(arr));
    }

}
