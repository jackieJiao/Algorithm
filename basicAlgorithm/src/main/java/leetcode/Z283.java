package leetcode;

import java.util.Arrays;

/*
* Input: [0,1,0,3,12]
  Output: [1,3,12,0,0]
* */
public class Z283 {

    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        new Z283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        //int i=0,j=0;
        //循环遍历i，j是下一个不为0的数字小标。
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            j=nextNotZero(j,nums);
            if (j>=nums.length)
                nums[i]=0;
            else {
                nums[i]=nums[j];
                j++;
            }


        }
    }

    private int nextNotZero(int j,int[] nums) {
        if (nums.length==j)
            return j;
        while(nums[j]==0){
            j++;
            if (j==nums.length)
                return j;
        }
        return j;
    }

}
