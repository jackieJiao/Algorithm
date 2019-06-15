package tree;

import java.util.Stack;

/*
 * @Param
 * */
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    /*
     * 第一种add代码相对复杂，逻辑更清晰
     * */
    /*

    public void add(E e){
        if (root==null){
            root=new Node(e);size++;
        }else add(root,e);
    }
    private void add(Node node, E e) {
        //终止条件： -- 多个终止条件---终止条件直接返回
        if (node.e.equals(e)) return;
        else if (node.e.compareTo(e)<0 && node.right==null){
            node.right=new Node(e);size++;
            return;
        }
        else if (node.e.compareTo(e)>0 && node.left==null){
            node.left=new Node(e);size++;
            return;
        }
        //规模减小
        if (node.e.compareTo(e)<0) add(node.right,e);
        else add(node.left,e);
    }*/

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        //终止条件
        if (node == null) {
            size++;
            return new Node(e);

        }
        //规模减小
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }

        return node;

    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        //2.终止条件
        if (node.e.compareTo(e) == 0)
            return true;
        else if (node == null)
            return false;

        //1.规模减少1
        if (e.compareTo(node.e) > 0)
            return contains(node.right, e);
        else //if (e.compareTo(node.e)<0)
            return contains(node.left, e);

    }

    //前序遍历操作，递归方法
    public void preOder() {
        preOder(root);
    }

    public void preOder(Node node) {
        //2.终止条件
        if (node == null)
            return;

        /*
         * 1.规模缩小。
         * 访问该节点---》访问该节点的左子树、和右子树。
         * */
        System.out.println(node.e);
        preOder(node.left);
        preOder(node.right);
    }

    //前序遍历，非递归
    //非递归方法，需要借助栈来记录访问顺序
    /*
     * 出栈的同时，入栈两个子节点。
     * */
    public void preOderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }

    }



    /*
    * 简单写法
    * 推荐第一种递归写法，逻辑比较清晰。
    *
    * if(node!=null){
        System.out.println(node.e);
        preOder(node.left);
        preOder(node.right);
    * }
    *
    * */


    /*
    * remove
    * removeMin 向左走，再也走不动了
    removeMax
     */

    public E minimum(){
        if (size==0)
            throw new IllegalArgumentException("empty");

        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    public E max(){
        if (size==0)
            throw new IllegalArgumentException("empty");
        return max(root).e;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }
    public E removeMax(){
        E e=max();
        //recurse removeMax(root)
        removeMax(root);
        return e;
    }

    private Node removeMax(Node node) {
        //end condition
        if (node.right == null) {
            Node leftN = node.left;
            node.left=null;
            size--;
            return leftN;
        }
        //-1
        node.right=removeMax(node.right);
        return node;
    }

    public E removeMin(){
        E e=minimum();
        removeMin(root);

        return e; }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right=null;
            size--;
            return right;
        }
        node.left=removeMin(node.left);
        return node;
    }

    public void remove(E e){
        remove(root,e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return node;
        }
        else if (e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }
        else //== keyPoint
        {
            //分三种情况，前两种比较简单
            if (node.left==null){
                Node rightNode = node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if (node.right==null){
                Node left = node.left;
                node.left=null;
                size--;
                return left;
            }
            /*
            核心代码！！！

            //hib deltion 左右都不空时，找到比该节点大的最小节点，取代该节点。
            */
            Node successor=minimum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            //删除当前节点。没用了
            node.left=node.right=null;
            return successor;
        }
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();

    }

    //递归遍历
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        //zhongzhi
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        // -1
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            System.out.println("sfdj" + num);
            bst.add(num);
        }
        bst.preOder();
        bst.preOderNR();

    }


}
