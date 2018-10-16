package LinkedList;
/*
* LinkedList 实现
* */
public class LinkedList<E> {

    private Node head;
    private int size;
    public LinkedList(){
        head=null;
        size=0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void addFirst(E e){
        Node node=new Node(e);
        node.next=head;
        head=node;
        size++;
    }

    public void add(int index,E e){
        if(index<0)
            throw new IllegalArgumentException("out index");
        if(index==0)
            addFirst(e);
        else {
            Node pre=head;
            for (int i=0;i<index-1;i++)
                pre=pre.next;
            Node node=new Node(e);
            node.next=pre.next;

            pre.next=node;
            size++;

        }
    }

    public void addLast(E e){
        add(size,e);
    }




    //内部类
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }



}
