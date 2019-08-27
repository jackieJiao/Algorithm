package leetcode;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrder_145 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /*/
     NO recursion
     /*/
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> resList = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root==null)
            return resList;
        stack.addLast(root);

        while(!stack.isEmpty()){
            TreeNode pollLast = stack.pollLast();
            resList.addFirst(pollLast.val);

            if (pollLast.left!=null)
                stack.addLast(pollLast.left);
            if (pollLast.right!=null)
                stack.addLast(pollLast.right);



        }
        return resList;

    }


    /*
    * 借助command对象
    * */
    public class Command{
        // go || print
        String key;
        TreeNode node;

        public Command(String key, TreeNode node) {
            this.key = key;
            this.node = node;
        }
    }


    /*
    * class
    * */
    public List<Integer> postorderTraversal1(TreeNode root){
        Stack<Command> stack = new Stack<>();
        LinkedList<Integer> resList = new LinkedList<>();

        while(root==null)
            return resList;

        stack.push(new Command("go",root));

        while (!stack.isEmpty()){
            Command peekCommand = stack.peek();
            stack.pop();

            if ("go"==peekCommand.key){
                stack.push(new Command("print",peekCommand.node));
                if (null!=peekCommand.node.right)
                    stack.push(new Command("go",peekCommand.node.right));

                if (null!=peekCommand.node.left)
                    stack.push(new Command("go",peekCommand.node.left));


            }else {
                assert ("print"==peekCommand.key);
                resList.addLast(peekCommand.node.val);

            }
        }
        return resList;


    }


}
