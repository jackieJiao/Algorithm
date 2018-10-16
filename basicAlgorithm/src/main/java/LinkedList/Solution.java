package LinkedList;

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
        ListNode head=new ListNode(1);


        new Solution().removeElements(head,3);
    }
}