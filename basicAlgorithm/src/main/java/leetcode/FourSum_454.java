package leetcode;

import java.util.HashMap;

public class FourSum_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //计算CD 和所有可能性=和频次 Map
        HashMap<Integer, Integer> cdMap = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int i1 = 0; i1 < D.length; i1++) {
                int sum=C[i]+D[i1];
                if (cdMap.containsKey(sum))
                    cdMap.put(sum,cdMap.get(sum)+1);
                else
                    cdMap.put(sum,1);
            }
        }

        //AB n*n
        int resultInt=0;
        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                int targetToSearch=0-A[i]-B[i1];
                if (cdMap.containsKey(targetToSearch))
                    resultInt+=cdMap.get(targetToSearch);

            }
        }
        return resultInt;
    }
}
