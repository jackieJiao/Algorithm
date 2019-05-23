package queue;

import java.util.Objects;

/*
* 循环队列
*
* 入队：1.是否满
* 2.
*
* */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front,tail;
    private int size;   //队列长度

    public LoopQueue(int c){
        data=(E[])new Object[c+1];
        front=0;
        tail=0;
        size=0;
    }
    public LoopQueue(){
        this(10);
    }
    public int getCapacity(){
        return data.length-1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail==front;
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length==front)
            resize(getCapacity()*2);
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;

    }

    private void resize(int newCapacity) {
        E[] newdata=(E[])new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            newdata[i]=data[(front+i)%data.length];
        }
        data=newdata;
        front=0;
        tail =size;

    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException(" queue is empty");
        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        //缩小容量
        if (size==getCapacity()/4 && getCapacity()/2!=0)
            resize(getCapacity()/2);
        return ret;

    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("is empty");
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue:size=%d,capacity=%d\n[",size,data.length);
        for (int i = front;i!=tail; i=(i+1)%data.length) {
            res.append(data[i]);
            if((i+1)%data.length!=tail)
                res.append(",");
        }
        res.append("]tail");
        return res.toString();
    }
}
