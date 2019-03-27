package thinkinginstring;

import java.util.HashMap;
import java.util.Map;

public class BitMove {
    public static void main(String[] args) {
        int i=-7;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i>>>2));
        System.out.println(Integer.toBinaryString(i>>2));
        int h=new Object().hashCode();
        System.out.println(h);
        System.out.println(Integer.toBinaryString(h));
        System.out.println(Integer.toBinaryString(1846274136));
        Object jiao=new Object();
        System.out.println(jiao.equals(null));
        Map map= new HashMap<>();
        map.put(null,"jiao");
        System.out.println(map.get(null));
        System.out.println(null ==null);
        System.out.println();
    }
}
