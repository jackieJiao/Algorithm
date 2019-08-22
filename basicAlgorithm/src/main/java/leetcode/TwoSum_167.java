package leetcode;

import shuzu.Array;

import java.util.Arrays;

public class TwoSum_167 {
    public static void main(String[] args) {
        int[] resultArray ={2,7,11,15};
        System.out.println(Arrays.toString(new TwoSum_167().twoSum2Points(resultArray,9)));

    }


    /*
    * 对撞指针思想
    * */
    public int[] twoSum2Points(int[] numbers, int target) {
        int[] resultArray = new int[2];
        int i=0,j=numbers.length-1;//[]
         while (j>i){
             if ((numbers[i]+numbers[j])<target)
                 i++;
             else if((numbers[i]+numbers[j])>target)
                 j--;
             else{
                 assert ((numbers[i]+numbers[j])==target);
                 resultArray[0]=i+1;
                 resultArray[1]=j+1;
                 return resultArray;
             }

         }
        return resultArray;

    }


    /*
    * 二分思想
    * */
    public int[] twoSum1(int[] numbers, int target) {
        int[] resultArray = new int[2];
        for (int i=0;i<numbers.length && numbers[i]<=target;i++){
            int l=i+1,r=numbers.length-1;
            while (r>=l){
                int mid=(l+r)/2;
                if ((numbers[i]+numbers[mid])<target)
                    l=mid+1;
                else if ((numbers[i]+numbers[mid])>target)
                    r=mid-1;
                else {
                    assert ((numbers[i]+numbers[mid])==target);
                    resultArray[0]=i+1;
                    resultArray[1]=mid+1;
                    return resultArray;

                }
            }
        }
        return resultArray;

    }

    public int[] twoSum(int[] numbers, int target) {
        int[] resultArray = new int[2];

        for (int i=0;i<numbers.length && numbers[i]<=target;i++){
            for (int j=i+1;j<numbers.length && (numbers[i]+numbers[j])<=target;j++){
                if (target==(numbers[i]+numbers[j])){
                    resultArray[0]=i+1;
                    resultArray[1]=j+1;
                    return resultArray;
                }

            }
        }
        return resultArray;

    }
}
