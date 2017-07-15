package com.algorithm.algorithms.union_find;

/**
 * Created by Administrator
 * on 2017/7/15 11:59.
 */
public class WeightedQuickUnionUF {

    private int[] array;
    private int[] size;

    public WeightedQuickUnionUF(int n) {
        for(int i = 0; i < n; i++){
            array[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i){
        while(i != array[i]){
            i = array[i];
        }
       return i;
    }

    public boolean connected(int x, int y){
        return root(x) == root(y);
    }

    public void union(int x, int y){
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
    }

}
