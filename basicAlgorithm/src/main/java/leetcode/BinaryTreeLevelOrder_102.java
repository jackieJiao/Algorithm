package leetcode;

import shuzu.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder_102 {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        que.add(2);
        System.out.println(que.poll());
        System.out.println(que.poll());
        System.out.println(que.isEmpty());

    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  public class Pair{
      TreeNode key;
        int level;

      public Pair(TreeNode key, int level) {
          this.key = key;
          this.level = level;
      }
  }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> resList = new ArrayList<>();
        Queue<Pair> que = new LinkedList<>();
        if (root==null)
            return resList;

        que.add(new Pair(root,1));
        while(!que.isEmpty()){
            Pair top=que.poll();
            if (top.level==(resList.size()+1)){
                ArrayList<Integer> innerList = new ArrayList<>();
                innerList.add(top.key.val);
                resList.add(innerList);
                //top 孩子节点加入队列
                if (top.key.left!=null)
                    que.add(new Pair(top.key.left,top.level+1));
                if (top.key.right!=null)
                    que.add(new Pair(top.key.right,top.level+1));
            }
            else if (top.level==(resList.size())){
                List innerList= resList.get(top.level-1);
                innerList.add(top.key.val);
                //top 孩子节点加入队列
                if (top.key.left!=null)
                    que.add(new Pair(top.key.left,top.level+1));
                if (top.key.right!=null)
                    que.add(new Pair(top.key.right,top.level+1));

            }

        }


        return resList;


    }
}
