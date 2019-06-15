package map;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {
    //内部类
    private class Node {
        public K key;
        public V value;
        public Node left,right;

        public Node(K key,V value) {
            this.key =key;
            this.value=value;
            left=null;
            right=null;
        }



        @Override
        public String toString() {
            return key.toString()+":"+ value.toString();
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root=add(root,key,value);

    }

    private Node add(Node node, K key, V value) {

        if (node==null){
            size++;
            return new Node(key,value);
        }

        //-1
        if (key.compareTo(node.key)<0)
            //左子树添加key之后的左节点。
            node.left=add(node.left,key,value);
        if (key.compareTo(node.key)>0)
            node.right=add(node.right,key,value);
        return node;

    }

    private Node getNode(Node node,K key){
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key)==0)
            return node;
        else if(key.compareTo(node.key)<0)
            return getNode(node.left,key);
        else return getNode(node.right,key);


    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root=remove(root,key);
            return node.value;
        }
        return null;

    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
            return node;
        }

        else if (key.compareTo(node.key)>0) {
            node.right=remove(node.right,key);
            return node;
        }
        else //==  该节点就是我们要删除的节点。
        {
            //最复杂的地方！！！
            //三种情况
            if (node.right==null){
                Node left = node.left;
                node.left=null;
                size--;
                return left;
            }
            if (node.left == null) {
                Node right = node.right;
                node.right=null;
                size--;
                return right;
            }

            //left right all not null;

            Node suc = min(node.right);
            suc.right=removeMin(node.right);
            suc.left=node.left;
            node.left=node.right=null;


            return suc;

        }


    }

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

    private Node min(Node node) {
        if (node.left==null)
            return node;

        return min(node.left);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException("no key");
        }

        node.value=value;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
