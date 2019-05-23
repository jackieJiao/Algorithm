package shuzu;


/*
* 泛型····不能放置基本类型
*
*
* */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity){
        data= (E[])new Object[capacity];
        size=0;
    }
    public Array(){
        this(10);
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size== 0;
    }

    public void addLast(E e){

        /*if(size==data.length)
            throw new IllegalArgumentException("fail add");

        data[size++]=e;*/

        add(size,e);
    }
    public void addFirst(E e){
        add(0,e);
    }

    public void  add(int index,E e){
        if(size==data.length){
             resize(2*size);
        }
            //throw new IllegalArgumentException("fail add");

        if(index<0 || index >size)
            throw  new IllegalArgumentException("index fail add");

        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];

        }
        data[index]=e;

        size++;
    }

    private void resize(int newsize) {
        //kuorong
        E[] newdata=(E[]) new Object[newsize ];

        for (int i = 0; i < size; i++) {
            newdata[i]=data[i];

        }

        data=newdata;
    }

    @Override
    public String toString(){
        StringBuilder s= new StringBuilder();
        s.append(String.format("Array size:%d,capacity:%d",size,data.length));
        s.append("【");
        for(int i=0;i<size;i++){
            s.append(data[i]);
            if(i!=size-1)
                s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

    public E get(int index){
        if(index<0||index>=size)
            throw new IllegalArgumentException("index fail");
        return data[index];
    }
    public E getLast(){
        return get(size-1);
    }
    public E getFirst(){
        return get(0);
    }

    void set(int index,E e){
        if(index<0||index>=size)
            throw new IllegalArgumentException("index fail");
        data[index]=e;
    }

    public Boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E remove(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("index fail");

        E r=data[index];

        for (int i=index;i<size-1;i++){
            data[i]=data[i+1];
        }
        size--;
        //释放对象的引用。非必须loitering object

        data[size]=null;

        if (size==data.length/2)
            resize(data.length/2);
        return r;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        int index=find(e);
        if(index!=-1)
            remove(index);

    }





}
