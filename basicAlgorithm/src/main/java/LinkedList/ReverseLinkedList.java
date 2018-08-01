package LinkedList;

import utils.Utils;

import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {
    /*
    * @para head node of the linkedlist
    * @return new head
    *
    * 思路：
    * 1.数量级减少一个，假设可以正常反转后，需要做那些操作？？
    * 2.终结条件
    *
    * */
    public Node reverseLinkedList(Node head) {
        if(head== null){
            return null;
        }
        if(head.getNext()==null){
            return head;
        }
        Node newHead=reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;

    }

    public static void main(String[] args) {
        List<String> list = Utils.generateStringList(5);
        Node headNode = CreateLinklist.fromListRecursion(list);
        Utils.printLinkedlist(headNode);
        Utils.printLinkedlist(new ReverseLinkedList().reverseLinkedList(headNode));


    }

}
