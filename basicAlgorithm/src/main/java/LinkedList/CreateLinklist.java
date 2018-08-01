package LinkedList;

import java.util.List;

public class CreateLinklist {
    public static Node fromListIterator(List<String> list){
        if(list.isEmpty()){
            return null;
        }
        Node preNode = new Node(list.get(0));

        for(int i=1;i<list.size();i++){
            Node node=new Node(list.get(i));
            node.setNext(preNode);
             preNode=node;
        }
        return preNode;
    }


    public static Node fromListRecursion(List<String> list){
        if(list.isEmpty()){
            return null;
        }
        Node head=new Node(list.get(0));

        Node newHead=fromListRecursion(list.subList(1,list.size()));
        head.setNext(newHead);
        return head;




    }
}
