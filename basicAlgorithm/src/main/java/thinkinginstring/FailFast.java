package thinkinginstring;

import java.util.*;

public class FailFast {
    public static void main(String[] args) {

        Collection<String> c = new ArrayList<String>();
        Iterator<String> it = c.iterator();
        //下面一行代码在it中间，会抛出ConcurrentModificationException
        c.add("An object");
        try {
            String s = it.next();
        } catch(ConcurrentModificationException e) {
            System.out.println(e);
        }
    }
}