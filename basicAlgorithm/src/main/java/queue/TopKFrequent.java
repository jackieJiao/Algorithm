package queue;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TopKFrequent {
    private class Freq{
        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        int e,freq;
    }
    private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq o1, Freq o2) {
            return o1.freq-o2.freq;
        }
    }
    public List<Integer> topKF(int[] nums,int k){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num,map.get(num)+1);
            else map.put(num,1);
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        for (Integer key : map.keySet()) {
            if (pq.size()<k)
                pq.add(new Freq(key,map.get(key)));
            else if(map.get(key)>pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key,map.get(key)));

            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (!pq.isEmpty())
            list.add(pq.remove().e);
        return list;
    }

}
