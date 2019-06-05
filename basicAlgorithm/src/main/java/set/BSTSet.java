package set;

import search.BST;
/*
* BSTSET 基于BST实现Set接口。
* HashSet 基于Hashmap。
* */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }


    public void remove(E e) {
        bst.remove(e);
    }
}
