package stack;

import shuzu.Array;

public class ArrayStack<E> implements Stack<E>{
     Array<E> array;
     public ArrayStack(int c){
         array= new Array<>(c);

     }
     public ArrayStack(){
         array=new Array<>();
     }
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public String toString(){
         StringBuilder res= new StringBuilder();
         res.append("stack:");
         res.append("[");
        for (int i = 0; i <= array.getSize()-1; i++) {
            res.append(array.get(i));
            if (i!=array.getSize()-1){
                res.append(",");
            }
        }
        res.append("]top");
        return res.toString();
    }




}
