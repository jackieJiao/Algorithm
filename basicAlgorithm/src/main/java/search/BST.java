package search;

import java.util.Stack;

public class BST<E extends Comparable<E>> {
    /*  root节点  */
    private Node root;

    /* ADD nodes */
    public void add(E e){
        if(root == null){
            root=new Node(e);
            size++;
        }
        else
            add(root,e);


    }
    /* recurse add*/
    private void add(Node root, E e) {
        // 终止条件
        /*if(root==null)
            root=new Node(e);*/

        if(e.equals(root.e))
            return;
        else if(e.compareTo(root.e)<0 && root.left == null){
            root.left=new Node(e);
            size ++;
            return;
        }
        else if(e.compareTo(root.e)>0 && root.right ==null){
            root.right=new Node(e);
            size++;
            return;
        }


        //正常递归
        if(e.compareTo(root.e)<0)
            add(root.left,e);
        else
            add(root.right,e);
    }

    /* recurse search*/

    public boolean contains(E e){
       return contains(root,e);

    }
    public boolean contains(Node node, E e){
        if(node==null)
            return false;
        if(node.e.compareTo(e)==0)
            return true;
        if(node.e.compareTo(e)<0)
            return contains(node.right,e);
        else
            return contains(node.left,e);

        /*
        !!!!!! 此处犯错误，不应该直接return contains(node.left,e)|| contains(node.right,e);
        //left
        contains(node.left,e);
        //right
        contains(node.right,e);
        */


    }
    /* 递归遍历 */
    public void  preoder(){
        preoder(root);


    }
    public void  preoder(Node node){
        if(node==null)
            return;
        System.out.println(node.e);
        preoder(node.left);
        preoder(node.right);

    }
    /* 非递归遍历 */

    Stack<Node> stack=new Stack<>();
    public void preoderNotR(){
        stack.push(root);
        while (0 != stack.size()){
            Node p=stack.pop();
            System.out.println(p.e);
            if (p.right!=null)
                stack.push(p.right);
            if(p.left!=null)
                stack.push(p.left);
        }
    }




    private int size;

    public BST(){
        root=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }








    private class Node{
        public E e;
        public Node left,right;
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }


}
