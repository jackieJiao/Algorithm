package unionFind;
/*
*  find方法中路径压缩彻底。
* 复杂度为O(log*n)，仅次于O(1）
*   log*n=1+log*(logn)
*
* */
public class UnionFind6 implements UF {
    private int[] parent;
    private int[] rank;

    public UnionFind6(int size) {
        parent=new int[size];
        rank=new int[size];
        for (int i = 0; i < size; i++) {
            parent[i]=i;
            rank[i]=1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /* find(p) 是找到p元素的根节点的值          */
    /* isConnected(p,q)   就是看find（p）==find(q)  */
    private int find(int p){
        //第一种：路径压缩的find的方法，但是压缩的不彻底。
        /*while (p!=parent[p]){
            *//*  路径压缩  p的值改为p的上上节点的值，下次查找可以节省查找次数*//*
            *//* 压缩后树的高度减少了，但是rank值不需要改变。所以rank并不等于高度。*//*
            parent[p]=parent[parent[p]];

            p=parent[p];}
        return p;*/

        //第二种实现：路径压缩彻底，每一个元素直接指向根节点。
        //递归实现 ,递归有一定的性能消耗，所以耗时更长。

        if (p!=parent[p])
            parent[p]=find(parent[p]);
        return parent[p];



    }


    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }
    /*  find(p)=find(q)   */
    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if (qRoot==pRoot)
            return;
        // 元素rank少的，合并到元素多的
        if (rank[pRoot]<rank[qRoot])
            parent[pRoot]=qRoot;
        else if(rank[qRoot]<rank[pRoot])
            parent[qRoot] = pRoot;
        else //rank ==
        {
            parent[qRoot] = pRoot;
            rank[pRoot]+=1;
        }


    }
}
