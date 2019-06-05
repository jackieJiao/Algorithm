package LinkedList;

/*
 * LinkedList 实现
 *
 * dummyhead的优势：
 * 统一逻辑。
 *
 * linkedlist:适合只对链表头进行操作。
 * */
public class LinkedList<E> {
    //内部类
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    //在指定索引位置add
    public void add(int index, E e) {
        if (index < 0)
            throw new IllegalArgumentException("out index");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;


        pre.next = new Node(e, pre.next);
        size++;


    }

    //在链表的头部add
    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index fail");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index failed");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;

        }
        cur.e = e;

    }


    public boolean contains(E e){
        Node cur=dummyHead.next;
        while(cur!=null){
            if(cur.e.equals(e))
                return true;
            cur=cur.next;

        }
        return false;
    }

    public E remove(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("index fail");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }
        /*
        * 容易出错的地方，注意引用的意思。
        * retNode pre 只是内存地址的引用
        * */
        Node retNode=prev.next;

        prev.next=retNode.next;

        retNode.next=null;
        size--;
        return retNode.e;
    }
    public E removeFirst(){
        return remove(0);

    }
    public void removeEles(E e){
        //假设链表有很多个元素等于e
        Node pre=dummyHead;
        while(pre.next!=null){
            //找到下一个不等于e的元素cur，pre=cur
            Node cur=pre.next;
            while(cur.e.equals(e))
                cur=cur.next;
            pre.next=cur;
            pre=cur;

        }

    }
    public void removeElement(E e){
        Node pre=dummyHead;
        //找到delnode
        while (pre.next!=null){
            if (pre.next.e.equals(e))
                break;
            pre=pre.next;
        }
        Node delNode=pre.next;
        pre.next= delNode.next;
        delNode.next=null;

    }
    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();

        Node cur=dummyHead.next;
        while(cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {

            linkedList.addFirst(i);
            System.out.println(linkedList);

        }

        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);


    }
}
