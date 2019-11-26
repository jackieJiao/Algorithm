package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    public static void main(String[] args) {
    String a="1";
    String b="2";

        System.out.println(a.compareTo(b));
    }



    //最大堆
    PriorityQueue<Integer> lo;


    //最小堆
    PriorityQueue<Integer> hi;

    /** initialize your data structure here. */
    public MedianFinder() {
        lo=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        hi=new PriorityQueue<Integer>((n1,n2)->n2-n1);
    }

    public void addNum(int num) {
        /*
        * 两个优先队列 lo hi，lo比hi多一个元素。
        * add（）过程：
        * 1、插入到lo
        * 2，hi.add(lo.poll);
        * 3, 判断if(hi.size>lo.size) : lo.add(hi.poll)
        *
        * */
        lo.add(num);
        hi.add(lo.poll());
        if(hi.size()>lo.size())
            lo.add(hi.poll());



    }

    public double findMedian() {
        if (lo.size()>hi.size())
            return (double)lo.peek();
        else
            return  (double) (lo.peek()+hi.peek())*0.5;

    }
}
