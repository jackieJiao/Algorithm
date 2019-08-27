package leetcode;

public class ParlindromeList_234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;
        //快慢指针找到中间节点；
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        //reverse [mid,null]
        // pre 是头节点。开始比较。
        ListNode pre=null;
        ListNode cur=slow;



        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }


        //pre is head .
        boolean flag=true;
        while(pre!=null && head!=null){
            if(pre.val!=head.val){
                flag= false;
                break;
            }
            pre=pre.next;
            head=head.next;


        }
        return flag;



    }
}
