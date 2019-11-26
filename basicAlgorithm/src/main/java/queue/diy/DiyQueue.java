package queue.diy;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class DiyQueue<T> implements Queue<T> {

    class DiyNode extends Node<T>{

        public DiyNode(T item) {
            super(item);
        }
    }

    //tou
    private volatile Node<T> head;

    //tail
    private volatile Node<T> tail;

    //大小size
    private AtomicInteger size=new AtomicInteger(0);

    //容量
    private final Integer capacity;

    private ReentrantLock putLock=new ReentrantLock();
    private ReentrantLock takeLocke=new ReentrantLock();


    public DiyQueue(){
        capacity=Integer.MAX_VALUE;
        head=tail=new DiyNode(null);
    }

    public DiyQueue(Integer capacity){
        if(null==capacity|| capacity<0)
            throw new IllegalArgumentException();
        this.capacity=capacity;
        head=tail=new DiyNode(null);
    }

    @Override
    public boolean put(T item) {
        if(null==item)
            return false;
        try{
            boolean lock = putLock.tryLock(300, TimeUnit.MILLISECONDS);
            if(!lock)
                return false;

            //校验队列大小
            if (size.get()>=capacity){
                System.out.println("queue is full");
                return false;
            }

            //!!! add to tail
            tail=tail.next=new DiyNode(item);

            //size++
            size.incrementAndGet();
            return  true;

        }catch(InterruptedException e){
            System.out.println("timeout Exception"+e);
            return false;
        }catch(Exception e){
            System.out.println("put error"+e);
            return false;
        }finally {
            putLock.unlock();
        }

    }

    @Override
    public T take() {
        try {
            boolean lock = takeLocke.tryLock(200, TimeUnit.MILLISECONDS);
            if (!lock)
                throw new RuntimeException("枷锁失败");

            Node expectHead = head.next;
            T result=head.item;
            head.item=null;
            head=expectHead;
            size.decrementAndGet();
            return result;

        } catch (InterruptedException e) {
            System.out.println("timeout"+e);
        } finally {
            takeLocke.unlock();
        }
        return null;
    }
}
