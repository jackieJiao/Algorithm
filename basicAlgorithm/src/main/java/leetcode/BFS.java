package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {





    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class Pair{
        TreeNode node;
        int level;
        public Pair(TreeNode node,int level){
            node=node;
            level=level;
        }
    }



    List<List<Integer>> levels=new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue queue=new LinkedList<Pair>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            System.out.println("jiao");
            Pair pair=(Pair)queue.poll();
            if(pair.level==levels.size())
                levels.add(new ArrayList<Integer>());
            levels.get(pair.level).add(pair.node.val);

            queue.add(new Pair(pair.node.left,pair.level+1));
            queue.add(new Pair(pair.node.right,pair.level+1));
        }
        return levels;
    }
}
