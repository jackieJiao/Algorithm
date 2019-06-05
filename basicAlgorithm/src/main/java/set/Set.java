package set;
/*
* set中元素不重复
* 应用：词汇量统计
* */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
