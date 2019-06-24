package unionFind;
/*
*  相对3，rank 是数组的高度
*
* */
public class UnionFind4 implements UF {
    private int[] parent;
    private int[] rank;

    public UnionFind4(int size) {
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

        while (p!=parent[p])
            p=parent[p];
        return p;

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
