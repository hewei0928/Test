package com.algorithm.algorithms.union_find;

/**
 * Created by HW
 * on 2017/7/15 11:59.
 * 快速union写法 改进写法 加入权的概念
 */
public class WeightedQuickUnionUF {

    private int[] array;
    private int[] size;//size[n] 表示 以n为根节点的树的权重
    private int count; //联通分量数量

    public int getCount() {
        return count;
    }

    public int[] getArray() {
        return array;
    }

    public WeightedQuickUnionUF(int n) {
        array = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    /**
     * 找到 i 位置的根节点的值
     * @param i
     * @return
     */
    private int root(int i){
        while(i != array[i]){
            i = array[i];
        }
       return i;
    }

    /**
     * 判断x, y 位置是否联通，即x,y的根节点值是否相同
     * @param x
     * @param y
     * @return
     */
    public boolean connected(int x, int y){
        try{
            return  root(x) == root(y);
        } catch (IndexOutOfBoundsException e){
            return  false;
        }
    }


    /**
     * 联通x，y 即将y的根节点设为x的根节点的根节点, 但为小树连接至大树
     * @param x
     * @param y
     */
    public void union(int x, int y){
        if(x < array.length && y < array.length){
            int i = root(x);
            int j = root(y);
            if(i == j){
                return;
            }
            if(size[i] > size[y]){
                array[j] = i;
                size[i] += size[j];
            } else{
                array[i] = j;
                size[j] += size[i];
            }
            count--;
        }
    }
}
