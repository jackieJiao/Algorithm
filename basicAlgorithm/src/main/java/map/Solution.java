package map;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.TreeMap;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2){
        TreeSet<Integer> objects = new TreeSet<>();
        for (int num : nums1) {
            objects.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (objects.contains(num)){
                list.add(num);
                objects.remove(num);
            }

        }
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer Int=new Integer("10");
        int i = Integer.valueOf(Int);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num))
                map.put(num,1);
            else
                map.put(num,map.get(num)+1);
        }
        List<Integer> list=new ArrayList();
        for (int num : nums2) {
            if (map.containsKey(num)){
                list.add(num);
                map.put(num,map.get(num)-1);
                if (map.get(num)==0)
                    map.remove(num);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();


    }
}
