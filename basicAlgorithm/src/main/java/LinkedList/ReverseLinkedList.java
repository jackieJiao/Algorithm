package LinkedList;

import utils.Utils;

import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {
    /*
    * 递归实现：
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


    /*
    *非递归实现：
    * 维护一个循环不变式，loop invariant
    * 编写循环体，使得每次循坏前进一步
    *
    *
    * */
    public Node reverseLinkedListWithLoop(Node head) {
      Node newhead=null;
      Node currenthead=head;
      while(currenthead!=null){
          Node next=currenthead.getNext();
          currenthead.setNext(newhead);
          newhead=currenthead;
          currenthead=next;
      }
      return newhead;

    }



    public static void main(String[] args) {
        List<String> list = Utils.generateStringList(10);
        Node headNode = CreateLinklist.fromListRecursion(list);
        Utils.printLinkedlist(headNode);
        System.out.println();
        Utils.printLinkedlist(new ReverseLinkedList().reverseLinkedListWithLoop(headNode));


    }

}
