package thinkinginstring;

import java.lang.ref.Reference;
import java.util.BitSet;

public class BitSetTest {
    public static void main(String[] args) {
       // Reference
        BitSet b=new BitSet();
        for(int i=0;i<70;i++){
            b.set(70);
            System.out.println(b.size());
        }
    }
}
