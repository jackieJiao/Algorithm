package leetcode;

import java.util.Arrays;

public class Duijiaoxian {


    public static void main(String[] args) {
        //int[][] test={{1,2,3},{4,5,6},{7,8,9}};
        int[][] test={};
        int[] t1=new Duijiaoxian().findDiagonalOrder(test);
        System.out.println(Arrays.toString(t1));
    }
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null)
            return new int[]{};
         if (matrix.length==0)
             return new int[]{};
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int[] resultInt=new int[(m+1)*(n+1)];
        int count=0;

        boolean isUp=true;
        for (int i = 0; i <=m + n; i++) {
            if (isUp){

                //up 阶段的初始左边为（i,0）,如果i越界，i>m-->（m,i-m）
                //x--, y++,判断越界。if越界，！isUp，
                //result_++
                int x,y;
                if (i>m){
                    x=m;
                    y=i-m;
                }else {
                    x=i;
                    y=0;
                }
                resultInt[count]=matrix[x][y];
                count++;
                x--;
                y++;
                //不越界就一直循环：
                while (x>=0&&y<=n){
                    resultInt[count]=matrix[x][y];
                    count++;
                    x--;
                    y++;
                }
                isUp=!isUp;

            }else {//down

                //down阶段初始坐标为(0,i),if i>n (i-n,n)
                //x++ y-- if越界，！isUp
                //result++
                int x,y;
                if (i>n){
                    x=i-n;
                    y=n;
                }else {
                    x=0;
                    y=i;
                }

                resultInt[count]=matrix[x][y];
                count++;
                x++;
                y--;
                //不越界就一直循环：
                while (y>=0&&x<=m){
                    resultInt[count]=matrix[x][y];
                    count++;
                    x++;
                    y--;
                }
                isUp=!isUp;


            }
        }




        return resultInt;


    }
}
