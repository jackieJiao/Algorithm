package queue;

public class LinkedListQueue<E> implements Queue<E> {
    /*private LinkedList list;
    * 不适用之前的list，不需要dummyhead
    * */
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

    private Node head,tail;
    private int size;
    public LinkedListQueue(){
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void enqueue(E e) {
        //在tail enqueue
        if (tail==null){
            tail=new Node(e);
            head=tail;
        }
        else {
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;

    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("empty Queue");
        //delete headNode;
        Node retNode=head;
        head=head.next;
        retNode.next=null;

        //if head,tail in same node. we should change tail too.
        if (head== null)
            tail=null;
        return retNode.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("LinkQueue: head-》");
        res.append("[");
        Node cur=head;
        while (cur!=null){
            res.append(cur.e);
            cur=cur.next;
            if (cur!=null)
                res.append(",");

        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> objectLinkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            objectLinkedListQueue.enqueue(i);
            System.out.println(objectLinkedListQueue);
        }
        objectLinkedListQueue.dequeue();
        System.out.println(objectLinkedListQueue);
    }
}
