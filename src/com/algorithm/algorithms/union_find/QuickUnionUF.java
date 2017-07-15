package com.algorithm.algorithms.union_find;

/**
 * Created by Administrator
 * on 2017/7/14 22:13.
 */
public class QuickUnionUF {

    private int[] array;

    public QuickUnionUF(int n) {
        this.array = new int[n];
        for(int i = 0; i < n; i++){
            this.array[i] = i;
        }
    }

    /**
     * 获取i节点对应的根节点
     * @param i
     * @return
     */
    private int root(int i){
        while(i != array[i]){
            i = array[i];
        }
        return i;
    }

    public void union(int x, int y){
        int i = root(x);
        int j = root(y);
        array[j] = i;
    }

    public boolean connected(int x, int y){
        return root(x) == root(y);
    }
}
