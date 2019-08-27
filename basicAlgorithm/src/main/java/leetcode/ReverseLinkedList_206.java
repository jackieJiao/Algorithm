package leetcode;


public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null){
            ListNode next=cur.next;

            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


