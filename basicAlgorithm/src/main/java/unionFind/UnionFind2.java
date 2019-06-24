package unionFind;
/*
* 树！底层实现是int数组。初始时候每个节点都指向自己。
*
* 孩子指向父亲
* union  ： p的根节点指向 q的根节点。
* union(3,4) int[4]=3
*
* */
public class UnionFind2 implements UF {
    private int[] parent;

    public UnionFind2(int size) {
        parent=new int[size];
        for (int i = 0; i < size; i++) {
            parent[i]=i;
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

        parent[pRoot]=qRoot;
    }
}
