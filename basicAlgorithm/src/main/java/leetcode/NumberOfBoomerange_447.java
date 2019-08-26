package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NumberOfBoomerange_447 {

    public static void main(String[] args) {
        int[][] param={{0,0},{1,0},{2,0}};
        System.out.println("-------------");
        System.out.println(new NumberOfBoomerange_447().numberOfBoomerangs(param));
    }
    public int numberOfBoomerangs(int[][] points) {
        //距离、个数 hashmap

        int count=0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(i==j)
                    continue;
                //计算每一个J到I的距离
                int distance=(points[j][0]-points[i][0])*(points[j][0]-points[i][0])+
                             (points[j][1]-points[i][1])*(points[j][1]-points[i][1]);
                if (hash.containsKey(distance))
                    hash.put(distance,hash.get(distance)+1);
                else hash.put(distance,1);
            }

            Iterator<Integer> iterator = hash.keySet().iterator();
            while (iterator.hasNext()){
                int temp=hash.get(iterator.next());
                System.out.println("+++++"+temp);
                System.out.println("count:"+count);
                count+=temp*(temp-1);
            }
        }
        //计算结果


        return count;

    }
}
