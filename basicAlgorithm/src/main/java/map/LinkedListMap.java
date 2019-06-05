package map;



public class LinkedListMap<K,V> implements Map<K,V> {
    //内部类
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key,V value,Node next) {
            this.key =key;
            this.value=value;
            this.next = next;
        }

        public Node(K key) {
            this(key,null, null);
        }

        public Node() {
            this(null,null, null);
        }

        @Override
        public String toString() {
            return key.toString()+":"+ value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead=new Node();
        size=0;
    }

    @Override
    public void add(K key, V value) {
        //key 唯一不重复
        Node node=getNode(key);
        if (node==null){
            dummyHead.next=new Node(key,value,dummyHead.next);
            size++;
        }else node.value=value;


    }

    @Override
    public V remove(K key) {
        Node prev=dummyHead;
        //找到需要删除的node的前一个prevNode
        while(prev.next!=null){
            if (prev.next.key.equals(key))
                break;
            prev=prev.next;
        }
        //prev.next==null,证明没有break、循环结束，没有找到key
        //所以下面首先需要判断一下，最后返回null
        if (prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node=getNode(key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key, V nvalue) {
        Node node=getNode(key);
        if (node==null){
            throw new IllegalArgumentException("no key");
        }
        node.value=nvalue;



    }
    /*
    * 增删改差基于getNode(key)方法。
    * */
    private Node getNode(K key){
        Node cur=dummyHead;
        while (cur!=null){
            if (cur.key.equals(key))
                return cur;
            cur=cur.next;
        }
        return null;
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
