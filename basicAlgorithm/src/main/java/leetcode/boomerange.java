package leetcode;

import java.util.HashMap;

public class boomerange {
    public int numberOfBoomerangs(int[][] points) {
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    int count = 0;
    for(int i = 0;i < points.length;i++){
        hashMap.clear();
        for(int j = 0;j < points.length;j++){
            if(i == j){
                continue;
            }
            int distance = (points[i][0] - points[j][0])*(points[i][0] - points[j][0]) + (points[i][1] - points[j][1])*(points[i][1] - points[j][1]);

            count += hashMap.getOrDefault(distance,0)*2;
            hashMap.put(distance,hashMap.getOrDefault(distance,0) + 1);
        }
    }
    return count;

}
}
