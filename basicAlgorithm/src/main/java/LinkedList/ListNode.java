package LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode(int[] arr) {
        this.val=arr[0];
        ListNode cur=this;
        for (int i = 1; i < arr.length; i++) {
            cur.next=new ListNode(arr[i]);
            cur=cur.next;

        }
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur=this;
        while(cur!=null){
            stringBuilder.append(cur.val+"->");
            cur=cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}