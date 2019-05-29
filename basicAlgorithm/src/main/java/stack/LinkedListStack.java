package stack;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList list;

    public LinkedListStack(){
        list=new LinkedList();
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E pop() {
        return (E) list.removeFirst();
    }

    @Override
    public E peek() {
        return (E) list.getFirst();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);

    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack : top->");
        stringBuilder.append(list);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack=new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
