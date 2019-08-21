package leetcode;


import java.util.Arrays;

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
* */
public class Z75_SortColor {
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        new Z75_SortColor().sortColors3Ways(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void sortColors3Ways(int[] nums) {
        int l=-1,i=0,r=nums.length;
        while (i<r){
            assert(nums[i]>=0&&nums[i]<=2);
            if (2==nums[i]){
                swap(nums,i,--r);
            }else if (1==nums[i]){
                i++;
            }else {
                swap(nums,i,++l);
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }


    public void sortColors(int[] nums) {
        int[] count=new int[3];
        for (int num : nums) {
            assert(num>=0&&num<=2);
            count[num]++;
        }

        //组合完计数算法，开始把0 1 2分别写入数组
        int current=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[current]=i;
                current++;
            }
        }

    }
}
