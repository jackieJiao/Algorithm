package tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.BlockingDeque;

/*
* 红黑树
* 三点基本性质：
* 1、根节点是黑色的。
* 2、红色的节点，孩子节点都是黑色的
* 3、从任意节点出发，到叶子节点，经过的黑色节点一样多。
* （因为红黑树是绝对平衡的树，深度相同。黑色代表深度，红色不代表深度。红色和黑色一起组成一个类似2-3树中三节点。）
* 4、红色节点只能在黑色的左边。（如果新红节点添加到了黑节点的右边，那么需要进行左旋转操作。）
*
*
*
* 根据以上性质证明：
* 红黑树是黑平衡的二叉树，不是严格意义的二叉树。最大高度为2*LogN（当每一个黑色节点都有一个红色的节点时候）
*
*
* 红黑树的查询效率不如avl树。
* 红黑树的add remove操作效率，要优于avl树
* */
public class RBTree<K extends Comparable<K>,V> {

    private static final boolean  RED =true;
    private static final boolean BLACK=false;

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left=null;
            right=null;
            //默认情况下，新节点都要融入
            color=RED;
        }
    }

    private Node root;
    private int size;

    public RBTree() {
        root=null;
        size=0;
    }

    /*
    *
    * 2-3树中添加新节点。
    * 1、直接添加到对应的位置，形成3节点
    * or、暂时形成四节点，拆分。
    *
    * */

    //想红黑树种添加新的元素
    public void add(K key,V value){
        root=add(root,key,value);
        root.color=BLACK;
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key,value);//RED NODE
        }

        //recurse
        if (key.compareTo(node.key)<0)
            node.left=add(node.left,key,value);
        else if (key.compareTo(node.key)>0)
            node.right=add(node.right,key,value);
        else //==
            node.value=value;
        //BRTree 性质维护

        //是否需要左旋转操作？
        if (isRed(node.right)&&!isRed(node.left))
            node=leftRotate(node);
        //是否需要右旋转？
        if (isRed(node.left)&&isRed(node.left.left))
            node=rightRotate(node);
        if(isRed(node.left)&&isRed(node.right))
            node =flipColors(node);


        return node;
    }

    private Node flipColors(Node node) {
        node.color= RED;
        node.left.color=BLACK;
        node.right.color=BLACK;
        return node;
    }

    private boolean isRed(Node node) {
        if(node == null)
            return BLACK;
        return node.color== RED;
    }

    //插入一个两节点的右边时候：需要左旋转
    private Node leftRotate(Node node){
        Node x=node.right;
        node.right=x.left;
        x.left=node;

        x.color=node.color;
        node.color=RED;
        return x;
    }
    //右旋转
    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node){
        Node x=node.left;
        node.left=x.right;
        x.right=node;

        x.color=BLACK;
        node.color=RED;
        return x;
    }


}
