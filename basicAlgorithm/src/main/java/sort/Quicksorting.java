package sort;

import java.util.Arrays;

public class Quicksorting {
    static int[] a = {5,1,7,2,1,3,9,1};


    public static void main(String[] args) {

        Rsort(0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    private static void Rsort(int i, int j) {
        //end condition
        if (j <= i) return;
        int start=i;
        int end=j;

        //1,meet i j,return MeetNum;
        int key = a[i];
        int MeetNum = 0;
        while (true) {
            /*
        *j left
        * swap
        * i right move
        * */
            while (a[j] > key) {
                j--;
                if (j == i) {
                    MeetNum = j;
                    a[j]=key;
                    break;
                }
            }

            if(i==j) break;
            a[i] = a[j];
            i++;
            if(i==j){
                MeetNum=j;
                a[j]=key;
                break;
            }

            while(a[i]<=key){
                i++;
                if(i==j){
                    MeetNum=j;
                    a[j]=key;
                    break;
                }
            }
            if(i==j) break;
            a[j]=a[i];
            j--;
            if(i==j){
                MeetNum=j;
                a[j]=key;
                break;
            }
        }


        //2,sortleft right recursion
        Rsort(start, MeetNum-1);
        Rsort(MeetNum+1, end);
    }
}
