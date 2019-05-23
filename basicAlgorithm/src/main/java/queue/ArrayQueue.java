package queue;

import shuzu.Array;
/*
* 基于数组实现的队列
*
* 最大的缺点是出队dequeue操作是O(n),在数据量大的时候，每次都要on操作
*
* 所以这种问题的解决办法是：循环数组实现队列。
* */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int c){
        array=new Array<E>(c);
    }

    public ArrayQueue(){
        array=new Array<E>();
    }

    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue:");
        res.append("front -[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i!=array.getSize()-1)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> objectArrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            objectArrayQueue.enqueue(i);
            System.out.println(objectArrayQueue);
            if (i%3 == 2){
                objectArrayQueue.dequeue();
                System.out.println(objectArrayQueue);
            }
        }
    }
}
