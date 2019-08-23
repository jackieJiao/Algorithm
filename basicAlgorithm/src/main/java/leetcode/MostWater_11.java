package leetcode;

import java.util.Arrays;

public class MostWater_11 {
    public static void main(String[] args) {
        int[] parm=new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(Arrays.toString(parm));
        System.out.println(new MostWater_11().maxArea(parm));
    }


    public int maxArea(int[] height) {
        int mostWasser=(height.length-1)*(height[0]<height[height.length-1]?height[0]:height[height.length-1]);
        int i=0,j=height.length-1;
        while(j>i+1){
            if (height[i]<height[j]){
                //i--->到更高的墙
                int iHei=height[i++];
                while (j>i&&height[i]<=iHei)
                    i++;
                //重新计算可以容纳体积
                    int newWasser=(j-i)*(height[i]<height[j]?height[i]:height[j]);
                    if (newWasser>mostWasser)
                        mostWasser=newWasser;



            }else{
                //<----j 至更高的墙
                int jHei=height[j--];
                while (j>i&&height[j]<=jHei)
                    j--;
                //重新计算可以容纳体积
                    int newWasser=(j-i)*(height[i]<height[j]?height[i]:height[j]);
                    if (newWasser>mostWasser)
                        mostWasser=newWasser;

            }
        }
        return mostWasser;
    }

}
