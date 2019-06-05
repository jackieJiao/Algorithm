package set;


import LinkedList.LinkedList;

public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;


    public LinkedListSet() {
    list=new LinkedList<E>();
    }

    @Override
    public void add(E o) {
        //Linkedlist允许重复，这里要处理一下
        if (!list.contains(o))
            list.addFirst(o);
    }

    @Override
    public void remove(E o) {
        list.removeElement(o);

    }

    @Override
    public boolean contains(E o) {
        return list.contains(o);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
