package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PathSum_112 {
    public static void main(String[] args) {
        int[] array=new int[10];
        System.out.println(Arrays.toString(array));

        List list= Collections.nCopies(10,-1);
        System.out.println(list);
        List lis=new ArrayList(list);

        lis.set(1,9);
        System.out.println(lis);
    }





    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean hasPathSum(TreeNode root, int sum) {


        if (root==null)
            return sum==0;
        if (hasPathSum(root.left,sum-root.val))
            return true;
        if (hasPathSum(root.right,sum-root.val));

         return true; 

    }
}
