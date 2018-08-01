import LinkedList.CreateLinklist;
import LinkedList.Node;
import utils.Utils;

import java.util.List;

public class CreateLinklistTest {
    public static void main(String[] args) {
        List<String> list= Utils.generateStringList(10);
        Node head= CreateLinklist.fromListIterator(list);
        Node head1= CreateLinklist.fromListRecursion(list);

        while(head.getNext()!=null){
            System.out.println(head.getValue());
            head=head.getNext();
        }



    }
}
