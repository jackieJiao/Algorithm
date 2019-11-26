package leetcode;

import java.util.HashMap;

public class CountSay_38 {
    public static void main(String[] args) {
        System.out.println(new CountSay_38().countAndSay(4));
    }


    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 1; i < n; i++) {
            String start=sb.toString();
            sb=new StringBuilder();
            HashMap<String, Integer> onekeyMap = new HashMap<>();
            for (int j = 0; j < start.length(); j++) {
                String key=String.valueOf(start.charAt(j));
                if (onekeyMap.size()<1)
                    onekeyMap.put(key,1);
                else {
                    assert(onekeyMap.size()==1);
                    if (onekeyMap.containsKey(key))
                        onekeyMap.put(key,onekeyMap.get(key)+1);
                    else {
                        assert(!onekeyMap.containsKey(key));
                        String oldkey=onekeyMap.keySet().iterator().next();
                        sb.append(onekeyMap.get(oldkey));
                        sb.append(oldkey);
                        onekeyMap.clear();
                        onekeyMap.put(key,1);
                    }
                }
            }
            if (onekeyMap.size()==1){
                String key=onekeyMap.keySet().iterator().next();
                sb.append(onekeyMap.get(key));
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
