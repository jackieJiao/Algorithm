package thinkinginstring;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursio {
    public String toString() {
        return " InfiniteRecursion address: " + this + "\n";
    }
    public static void main(String[] args) {
        List<InfiniteRecursio> v =
                new ArrayList<InfiniteRecursio>();
        for(int i = 0; i < 10; i++)
            v.add(new InfiniteRecursio());
        System.out.println(v);
    }
}