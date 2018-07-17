import sort.InsertionSort;
import utils.Utils;

public class InsertionSortTest {
    public static void main(String[] args) {
        Integer [] a= Utils.generateIntArray();
        InsertionSort.sort(a);
        for (int x:a
             ) {
            System.out.println(x);
        }
    }
}
