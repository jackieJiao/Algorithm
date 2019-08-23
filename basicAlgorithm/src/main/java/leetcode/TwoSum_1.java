package leetcode;

import java.util.HashMap;

public class TwoSum_1 {

    public static void main(String[] args) {
        System.out.println(new Integer(-1));
    }
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int targetTosearch=target-nums[i];
            if (hashmap.containsKey(targetTosearch))
                return new int[]{hashmap.get(targetTosearch),i};
            else
                hashmap.put(nums[i],i);

        }
        return new int[]{};
    }
}
