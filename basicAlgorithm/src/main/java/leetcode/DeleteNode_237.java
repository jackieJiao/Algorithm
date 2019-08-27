package leetcode;

public class DeleteNode_237 {
    public class ListNode {
        int val;
        ReverseLinkedList_206.ListNode next;
        ListNode(int x) { val = x; }
    }


    public void deleteNode(ListNode node) {

        //由于不知道前序节点的是什么。只能通过改变该节点的值。

        node.val=node.next.val;

        //delete nextNode;
        // 最后， 考虑边界条件

        node.next=node.next.next;

    }
}
