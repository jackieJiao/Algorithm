import sort.InsertionSort;
import sort.ShellSort;
import utils.Utils;

public class InsertionSortTest {
    public static void main(String[] args) {
        Integer [] a= Utils.generateIntArray(10);
        Integer [] b=a;
        /*for (int x:a
                ) {
            System.out.print(x+" ");
        }
        System.out.println("jdlfakjsdlkfj");
        for (int x:b
                ) {
            System.out.print(x+" ");
        }*/

        long start=System.currentTimeMillis();
        ShellSort.sort(a);
        System.out.println(System.currentTimeMillis()-start);

        long start1=System.currentTimeMillis();
        InsertionSort.sort(b);
        System.out.println(System.currentTimeMillis()-start1);


        for (int x:a
             ) {
            System.out.print(x+" ");
        }
    }
}
