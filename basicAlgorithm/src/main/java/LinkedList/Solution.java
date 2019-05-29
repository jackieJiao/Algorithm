package LinkedList;

import java.util.List;

/*
*
* Remove Linked List Elements
*
* 删除Node，需要找到preNode
* 由于head节点没有preNode
* 所以，借用dummyhead
*
* */
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dn=new ListNode(99);
        dn.next=head;

        ListNode pre=dn;

        while(pre.next!=null){
            if(pre.next.val==val)
                pre.next=pre.next.next;
            else
                pre=pre.next;
        }
        return dn.next;

    }


    public static void main(String[] args) {
       int[] nums={1,3,5,8,5,7};
        ListNode head=new ListNode(nums);
        System.out.println(head);
        new Solution().removeElements(head,5);
        System.out.println(head);
    }
}