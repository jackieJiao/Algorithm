package leetcode;



import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares_279 {

    public static void main(String[] args) {
        ArrayList<Boolean> visited = new ArrayList<>(13);
        visited.set(12,true);
    }
    public class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int numSquares(int n) {
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(n,0));

        boolean[] visited = new boolean[n+1];
        visited[n]=true;

        while (!queue.isEmpty()){
            int num=queue.peek().first;
            int level=queue.peek().second;
            queue.poll();

            if (num==0)
                return level;

            for (int i=1;num-i*i>=0;i++){
                if (!visited[num-i*i]){
                    queue.add(new Pair(num-i*i,level+1));
                    visited[num-i*i]=true;
                }

            }

        }
        throw new IllegalArgumentException();



    }

}
