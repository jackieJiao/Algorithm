package queue.diy;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
    int size;
    ReentrantLock lock=new ReentrantLock();
    LinkedList<E> list=new LinkedList<>();

    //两个等待条件。
    Condition notFull=lock.newCondition();
    Condition notEmpty=lock.newCondition();

    public MyBlockingQueue(int size){
        this.size=size;
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try{
            while(list.size()==size)
                notFull.await();
            list.add(e);
            System.out.println("put"+e);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }



    public E take() throws InterruptedException {
        E e;
        lock.lock();
        try{
            while(list.size()==0)
                notEmpty.await();
            e=list.removeFirst();
            System.out.println("take"+e);
            notFull.signal();
            return e;
        }finally {
            lock.unlock();
        }
    }
}
