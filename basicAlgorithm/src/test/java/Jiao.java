import java.util.*;
import java.util.stream.Collectors;

public class Jiao {
    /*static HashSet<Integer> set;
    static {
        int[] arr={659000,654300,654200,654000,653200,653100,653000,652900,652800,652700,652300,652200,652100,650200,650100,640500,640400,640300,640200,640100,632800,632700,632600,632500,632300,632200,632100,630100,623000,622900,621200,621100,621000,620900,620800,620700,620600,620500,620400,620300,620200,620100,611000,610900,610800,610700,610600,610500,610400,610300,610200,610100,542600,542500,542400,542300,542200,542100,540100,533400,533300,533100,532900,532800,532600,532500,532300,530900,530800,530700,530600,530500,530400,530300,530100,522700,522600,522300,520600,520500,520400,520300,520200,520100,513400,513300,513200,512000,511900,511800,511700,511600,511500,511400,511300,511100,511000,510900,510800,510700,510600,510500,510400,510300,510100,500100,469000,460200,460100,451400,451300,451200,451100,451000,450900,450800,450700,450600,450500,450400,450300,450200,450100,445300,445200,445100,442000,441900,441800,441700,441600,441500,441400,441300,441200,440900,440800,440700,440600,440500,440400,440300,440200,440100,433100,431300,431200,431100,431000,430900,430800,430700,430600,430500,430400,430300,430200,430100,429000,422800,421300,421200,421100,421000,420900,420800,420700,420600,420500,420300,420200,420100,419000,411700,411600,411500,411400,411300,411200,411100,411000,410900,410800,410700,410600,410500,410400,410300,410200,410100,371700,371600,371500,371400,371300,371200,371100,371000,370900,370800,370700,370600,370500,370400,370300,370200,370100,361100,361000,360900,360800,360700,360600,360500,360400,360300,360200,360100,350900,350800,350700,350600,350500,350400,350300,350200,350100,341800,341700,341600,341500,341400,341300,341200,341100,341000,340800,340700,340600,340500,340400,340300,340200,340100,331100,331000,330900,330800,330700,330600,330500,330400,330300,330200,330100,321400,321300,321200,321100,321000,320900,320800,320700,320600,320500,320400,320300,320200,320100,310100,232700,231200,231100,231000,230900,230800,230700,230600,230500,230400,230300,230200,230100,222400,220800,220700,220600,220500,220400,220300,220200,220100,211400,211300,211200,211100,211000,210900,210800,210700,210600,210500,210400,210300,210200,210100,152900,152500,152200,150900,150800,150700,150600,150500,150400,150300,150200,150100,141100,141000,140900,140800,140700,140600,140500,140400,140300,140200,140100,131100,131000,130900,130800,130700,130600,130500,130400,130300,130200,130100,120100,110100};
        set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);

        }
    }*/
    public static void main(String[] args) {

        System.out.println(-123%10);
        System.out.println(-123/10);
        System.out.println(Integer.MAX_VALUE);


    }


    public void moveZeroes(int[] nums) {
        int i=0;
        while(nums[i]!=0&&i<nums.length){
            i++;
        }
        int slow=i;
        for(int quick=i+1;quick<nums.length;quick++)
        {
            if(nums[quick]!=0){
                nums[slow]=nums[quick];
                slow++;
            }
        }
        while(slow<nums.length){
            nums[slow++]=0;

        }

    }


    public int[] plusOne(int[] digits) {
        List<Integer> res=Arrays.stream( digits ).boxed().collect(Collectors.toList());
        int i=res.size()-1;
        int temp=0;
        do{

            if (res.get(i)==9){
                res.set(i,0);
                temp=1;
            }else {
                res.set(i,res.get(i)+1);
                temp=0;
            }
            i--;
        }while(temp==1&&i>=0);

        if (temp==1)
            res.add(0,1);
        int[] d=new int[res.size()];
        for (int j=0;j<res.size();j++){
            d[j]=res.get(j);
        }




        return  d;

    }

    public int maxProfit(int[] prices) {
        //s 第一次考虑的下标值；
        return calcu(prices,0);
    }

    private int calcu(int[] prices, int s) {

        int max=0;
        for(int i=0;i<prices.length;i++){
            int maxp=0;
            for (int j=i+1;j<prices.length;j++){
                if (prices[j]>prices[i]){
                    int profit=calcu(prices,j+1)+prices[j]-prices[i];
                    if (profit>maxp)
                        maxp=profit;
                }
            }
            if (maxp>max)
                max=maxp;
        }



        return max;
    }

    // 7 ` 整数取反；
    public int reverse(int x){
        int rev=0;
        while(x!=0){
            int pop=x%10;
            x/=10;
            if (rev>Integer.MAX_VALUE/10) return 0;
            if (rev<Integer.MIN_VALUE/10) return 0;


            rev=rev*10+pop;

        }
        return rev;
    }
/*
*
* 242. Valid Anagram
*
* */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

    }



    public String countAndSay(int n) {
        if(n==1)
            return "1";
        return countAndSayLine(countAndSay(n-1));
    }
    public String countAndSayLine(String line){
        StringBuilder sb=new StringBuilder();
        int i=0;
        int count=0;
        while(i<line.length()){
            if(i==0||line.charAt(i)==line.charAt(i-1))
                count++;
            else{
                sb.append(count).append(line.charAt(i-1));
                count=1;
            }

            if(i==line.length()-1)
                sb.append(count).append(line.charAt(i));
            i++;



        }
        return sb.toString();

    }


    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }



}
