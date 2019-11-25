package leetcode;

public class MinSizeSum_209 {
    public static void main(String[] args) {
        int min=new MinSizeSum_209().minSubArrayLen(7,new int[]{2,3,1,2,4,3});
        System.out.println(min);
    }
    public int minSubArrayLen(int s, int[] nums) {
        //int quick=0;
        int slow=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int quick=0;quick<nums.length;quick++){
            sum+=nums[quick];
            while(sum>=s){
                min=Math.min(min,quick-slow+1);

                sum-=nums[slow];
                slow+=1;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
