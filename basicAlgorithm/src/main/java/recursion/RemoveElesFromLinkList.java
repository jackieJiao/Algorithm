package recursion;

import LinkedList.Node;

/*
 * 递归实现删除链表中的所有数字。
 *
 * 思路：
 * 1，终结条件是：链表为空。
 * 2.缩小规模-1，
 * 3、head 和 resNodes判断。
 *
 * 第三点很重要。
 * */
public class RemoveElesFromLinkList {
    public Node removeEles(Node head,String val){
        if (head==null)
            return null;
        head.setNext(removeEles(head.getNext(),val));
        return head.getValue().equals(val)?head.getNext():head;
    }

    public static void main(String[] args) {

    }
}




