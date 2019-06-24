package tree;

import shuzu.Array;

import java.util.ArrayList;
import java.util.Stack;

/*
 * @Param
 * */
public class AVLTree<K extends Comparable<K>,V> {
    private class Node {
        public V value;
        public K key;

        public Node left, right;
        public int height;

        public Node(K key,V value) {
            this.key = key   ;
            this.value=value;
            left   = null;
            right  = null;
            height = 1   ;
        }

    }

    private Node root;
    private int  size;

    public AVLTree() {
        root = null;
        size = 0;
    }


    private int getHeight(Node node){
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    // 获得节点的平衡因子
    private int getBalanceFactor(Node node){
        if (node == null) {
            return 0;
        }

        return getHeight(node.left)-getHeight(node.right);
    }
    public boolean isBST(){
        ArrayList<K> keys=new ArrayList<K>();
        inOrder(root,keys);
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i-1).compareTo(keys.get(i))>0)
                return false;
        }
        return true;


    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }

        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);

    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor =getBalanceFactor(node);
        if (Math.abs(balanceFactor)>1)
            return false;
        return isBalanced(node.left) &&isBalanced(node.right);
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



    /*
    *旋转分为三种，
    *LL右旋转
    *RR左旋转
    *LR先对左子树左旋，然后整体右旋转
    *RL同上   */

    /* 右子树的高度-左子树的高度>1  */
    private Node rightRotate(Node y){
        Node x=y.left;
        Node T3=x.right;

        x.right=y;
        y.left=T3;
        //更新height
        y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }

    private Node leftRotate(Node y){
        Node x=y.right;
        Node T3=x.left;

        x.left=y;
        y.right=T3;

        //update height
        y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }
    //

    public void add(K key,V value) {
        root = add(root, key,value);
    }

    private Node add(Node node, K key,V value) {
        //终止条件
        if (node == null) {
            size++;
            return new Node(key,value);

        }
        //规模减小
        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key,value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key,value);
        }
        /*
        *
        *
        * 平衡过程
        *
        * */
        // 添加完，需要在这里更新Height值
        /* node.height 的计算也是递归实现的。终结条件的时候，node的父亲节点会增加1，递归的所有父亲节点也会增加1*/
        node.height=1+Math.max(getHeight(node.left),getHeight(node.right));

        //计算每个节点的平衡因子
        int balanceFactor=getBalanceFactor(node);
        if (Math.abs(balanceFactor)>1)
            System.out.println(balanceFactor);



        //执行平衡动作！！！ if balanceFactor>1
        //LL情况：右旋转
        if (balanceFactor>1&&getBalanceFactor(node.left)>=0)
           return rightRotate(node);
        //RR 左旋转
        if (balanceFactor<-1 && getBalanceFactor(node.right)<=0)
            return leftRotate(node);
        //LR
        if (balanceFactor>1&& getBalanceFactor(node.left)<0){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        //RL
        if (balanceFactor<-1&&getBalanceFactor(node.right)>0){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }


        return node;

    }

    public boolean contains(K e) {
        return contains(root, e);
    }

    private boolean contains(Node node, K e) {
        //2.终止条件
        if (node.key.compareTo(e) == 0)
            return true;
        else if (node == null)
            return false;

        //1.规模减少1
        if (e.compareTo(node.key) > 0)
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
        System.out.println(node.key);
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
            System.out.println(cur.key);
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

    public K minimum(){
        if (size==0)
            throw new IllegalArgumentException("empty");

        return minimum(root).key;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    public K max(){
        if (size==0)
            throw new IllegalArgumentException("empty");
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }
    public K removeMax(){
        K e=max();
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

    public K removeMin(){
        K e=minimum();
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

    public void remove(K e){
        remove(root,e);
    }

    private Node remove(Node node, K e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.key)<0){
            node.left=remove(node.left,e);
            return node;
        }
        else if (e.compareTo(node.key)>0){
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
        res.append(generateDepthString(depth) + node.key + "\n");
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


}
