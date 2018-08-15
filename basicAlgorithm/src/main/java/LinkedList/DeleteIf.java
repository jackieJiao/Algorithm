package LinkedList;

import utils.Utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DeleteIf {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for (int j=i;j<nums.length;j++){
                if(i+j==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;

    }
    /*
    * 循环实现
    * */
    public Node deleteifWithLoop(Node head){
        //loop invariant
        Node pre=head;
        Node next=head.getNext();
        while(next!=null){
            if(next.getValue()=="2"){
                next=next.getNext();
                pre.setNext(next);
            }else {
                pre=next;
                next=next.getNext();
            }
        }
        return (head.getValue()=="2")?head.getNext():head;


    }

    public static void main(String[] args) {
        Node headoflist=  CreateLinklist.fromListIterator(Arrays.asList(new String []{"2","1","2","3","4","5","2","2"}));
        Utils.printLinkedlist(headoflist);
        System.out.println();

        Utils.printLinkedlist(new DeleteIf().deleteifWithLoop(headoflist));

        System.out.println();
        System.out.println(new DeleteIf().deleteifWithLoop(headoflist).getNext().getValue());


    }

}
