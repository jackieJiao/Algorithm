package unionFind;

import java.util.Random;

public class Main {
    private static double testUF(UF uf,int m){
        int size=uf.getSize();
        Random random=new Random();
        long start=System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a=random.nextInt(size);
            int b=random.nextInt(size);
            uf.unionElements(a,b);
        }
        for (int i = 0; i < m; i++) {
            int a=random.nextInt(size);
            int b=random.nextInt(size);
            uf.isConnected(a,b);
        }

        long end=System.nanoTime();
        return (end-start)/1000000000.0;
    }
    public static void main(String[] args) {

        int size=10000000;
        int m=10000000;
        //UnionFind1 unionFind1 = new UnionFind1(size);
       // UnionFind2 unionFind2 = new UnionFind2(size);
        UnionFind3 unionFind3 = new UnionFind3(size);
        UnionFind4 unionFind4 = new UnionFind4(size);
        UnionFind5 unionFind5 = new UnionFind5(size);
        UnionFind6 unionFind6 = new UnionFind6(size);
       // System.out.println("1:"+testUF(unionFind1,m));
       // System.out.println("2:"+testUF(unionFind2,m));
        System.out.println("3:"+testUF(unionFind3,m));
        System.out.println("4:"+testUF(unionFind4,m));
        System.out.println("5:"+testUF(unionFind5,m));
        System.out.println("6:"+testUF(unionFind6,m));


    }
}
