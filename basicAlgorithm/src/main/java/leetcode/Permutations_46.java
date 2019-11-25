package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {


    public static void main(String[] args) {
        List<List<Integer>> per=new Permutations_46().permute(new int[]{1,2,3});
        System.out.println(per.size());
    }
    public List<List<Integer>> res;
     public boolean[] used;
    // index 结果中有多少个元素。p 排列具体是什么样的

    public void generatePermutation(int[] nums,int index,List<Integer> p){
        if (index==nums.length){
            res.add(new ArrayList<>(p));
            return ;
        }
        //final condition
        //recursion
        for (int i = 0; i < nums.length; i++) {

            if (!used[i]){
                p.add(nums[i]);
                used[i]=true;
                generatePermutation(nums,index+1,p);
                p.remove(Integer.valueOf(nums[i]));
                used[i]=false;
            }
        }
        return;


    }
    public List<List<Integer>> permute(int[] nums) {
        used=new boolean[nums.length];

        res=new ArrayList<>();
        List<Integer> p=new ArrayList<>();
        if (nums.length==0)
            return res;
        generatePermutation(nums,0,p);
        return res;


    }
}
