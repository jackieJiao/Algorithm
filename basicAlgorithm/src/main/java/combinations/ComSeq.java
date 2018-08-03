package combinations;

import utils.Utils;

import java.util.Arrays;
import java.util.List;

public class ComSeq {
    public static void main(String[] args) {

        List<String> list = Utils.generateStringList(10);
        int n=3;
        getseq(list,n);



        List<String> list1 = Utils.generateStringList(10);
        getseqByRecursion(list1,n);
    }
    /*
    * 非递归实现
    * */
    private static void getseq(List list, int n) {
        for(int i=0;i<list.size()&&(list.size()-i>=n);i++){
            for(int j=0;j<n;j++){
                System.out.print(list.get(i+j));
            }
            System.out.println();
        }
        System.out.println("以下为递归实现：");
    }
    /*
    * 递归实现
    * */
    private static void getseqByRecursion(List list, int n) {
        //如果第一个元素之后的<n,直接return
        if(list.size()<n) return;
        //包含第一个元素，此为终止条件
        System.out.print(list.get(0));
        //输出剩下n-1个
        for(int i=1;i<n;i++){
            System.out.print(list.get(i));
        }
        System.out.println();
        //一般情况
        getseqByRecursion(list.subList(1,list.size()),n);
    }

}
