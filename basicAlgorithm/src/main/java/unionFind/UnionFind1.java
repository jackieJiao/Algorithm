package unionFind;

public class UnionFind1 implements UF {

    private int[] id;
    /* 每一个元素的值都不相同，代表都不相交 */
    public UnionFind1(int size) {
        id=new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i]=i;
        }
    }



    @Override
    public int getSize() {
        return id.length;
    }

    /* 查找元素p的编号 */
    private int find(int p){
        return id[p];
    }

    /* 元素P 和元素q 的编号是否相同，相同则属于同一个集合 */
    /* O(1) 复杂度 */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    /* 复杂度O（n）*/
    // 需要被改进

    @Override
    public void unionElements(int p, int q) {
        int pID=find(p);
        int qID=find(q);
        if (pID==qID)
            return;
        for (int i = 0; i < id.length; i++)
            if (id[i]==pID)
                id[i]=qID;

    }
}
