package queue.diy;
//queue接口
//jiaozhijun
public interface Queue<T> {
    //放数据
    //@param item 入参
    //@return true 成功 失败；
    boolean put(T item);
    /*
    * take data
    * */
    T take();

    class Node<T>{
        T item;
        Node<T>  next;
        public Node(T item){
            this.item=item;
        }
    }
}
