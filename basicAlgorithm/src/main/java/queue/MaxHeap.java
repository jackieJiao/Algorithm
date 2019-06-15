package queue;

import map.Map;
import shuzu.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data=new Array<>(capacity);
    }

    public MaxHeap() {
        data=new Array<>();
    }
    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index 0 ");
        return (index-1)/2;
    }

    private int leftChild(int index){
        return index*2+1;
    }
    private int rightChild(int index){
        return index*2+2;
    }
    //增加元素
    public void add(E e){
        data.addLast(e);
        siftup(data.getSize()-1);
    }

    private void siftup(int k) {
        while (k>0 && data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
        }
    }

    public E extractMax(){
        E ret =findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
         siftDown(0);


        return ret;

    }

    private void siftDown(int k) {
        while(leftChild(k)<data.getSize()){
            int j=leftChild(k);
            if (j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0)
                j++;

            // data[j] 是左右孩子中的最大值
            //data[j] he data[k] compare
            if (data.get(k).compareTo(data.get(j))>=0)
                break;
            data.swap(k,j);
            k=j;


        }
    }

    public E findMax() {
        return data.get(0);
    }

    //替换元素
    public E replace(E e){
        E ret=findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    //heapify 复杂度 logN
    public MaxHeap(E[] arr){
        data=new Array<E>(arr);
        for (int i=parent(data.getSize()-1);i>=0;i--){
            siftDown(i);
        }

    }





}
