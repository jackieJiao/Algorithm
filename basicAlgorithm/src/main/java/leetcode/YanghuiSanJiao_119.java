package leetcode;

import java.util.ArrayList;
import java.util.List;

public class YanghuiSanJiao_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre=new ArrayList();
        List cur=new ArrayList();
        for(int i=0;i<=rowIndex;i++){
            //组装每一行。作为cur
            cur=new ArrayList();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                    cur.add(1);
                else
                    cur.add(pre.get(j)+pre.get(j-1));
            }
            pre=cur;



        }
        return cur;
    }
}
