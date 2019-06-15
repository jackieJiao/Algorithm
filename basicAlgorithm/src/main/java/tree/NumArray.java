package tree;



class NumArray {
    class SegmentTree<E> {

        private E[] data;
        private E[] tree;
        private Marger<E> marger;
        public SegmentTree(E[] arr, Marger<E> marger) {
            data=(E[]) new Object[arr.length];
            this.marger = marger;
            for (int i = 0; i < arr.length; i++) {
                E e=arr[i];
                data[i]=e;
            }

            tree= (E[]) new Object[4*arr.length];
            buildSegmentTree(0,0,data.length-1);

        }

        //zai treeindex位置，创建表示区间【l,r】的线段树
        private void buildSegmentTree(int treeIndex, int l, int r) {
            if (l==r){
                tree[treeIndex]=data[l];
                return;
            }

            int leftindex=leftChild(treeIndex);
            int rightindex=rightChild(treeIndex);
            int mid=l+(r-l)/2;
            buildSegmentTree(leftindex,l,mid);
            buildSegmentTree(rightindex,mid+1,r);
            tree[treeIndex]= marger.marger(tree[leftindex],tree[rightindex]);


        }

        public int getSize(){
            return data.length;
        }

        public E get(int index){
            if (index<0||index>=data.length)
                throw new IllegalArgumentException("index fail");
            return data[index];
        }

        private int leftChild(int index){
            return 2*index+1;
        }
        private int rightChild(int index){
            return 2*index+2;
        }

        public E query(int queryL, int queryR){
            return query(0,0,data.length-1,queryL,queryR);
        }

        private E query(int treeIndex, int l, int r, int queryL, int queryR) {
            //终止条件
            if (l==queryL&&r==queryR)
                return tree[treeIndex];
            //规模-1
            int mid=l+(r-l)/2;
            int treeLeftIndex=leftChild(treeIndex);
            int treeRightIndex=rightChild(treeIndex);
            //最左边 、最右边、或者横跨左右两边。
            if (queryL>mid)
                return query(treeRightIndex,mid+1,r,queryL,queryR);
            else if (queryR<mid)
                return query(treeLeftIndex,l,mid,queryL,queryR);
            //3` 两边都有

            E leftResult=query(treeLeftIndex,l,mid,queryL,mid);
            E rightResult=query(treeRightIndex,mid+1,r,mid+1,queryR);
            return marger.marger(leftResult,rightResult);

        }

        public String toString(){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < tree.length; i++) {
                if (tree[i]!=null)
                    res.append(tree[i]);
                else res.append("null");
                res.append("+");
            }
            return res.toString();

        }
    }
    interface Marger<E> {
        public E marger(E a,E b);
    }
    private SegmentTree<Integer> segmentTree;
    /*public NumArray(int[] nums) {
        if (nums.length>0){
            Integer[] integers = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++)
                integers[i] = nums[i];
            segmentTree = new SegmentTree<>(integers, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i,j);

    }*/
    private int[] sum;

    public NumArray(int[] nums) {
        sum=new int[nums.length+1];
        sum[0]=0;
        for (int i = 1; i < sum.length; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];

    }
}