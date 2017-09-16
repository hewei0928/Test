package com.algorithm.algorithms.union_find;

/**
 * Created by HW
 * on 2017/7/14 22:13.
 * 判断二位数组中a[n][m],a[i][j]是否联通
 * 快速union写法
 */
public class QuickUnionUF {

    private int[] array; //样本总集合，是二位数组则转为一维数组

    private int count; //联通分量数量

    public QuickUnionUF(int i) {
        this.array = new int[i];
        for(int j = 0; j < i; j++){
            array[j] = j;
        }
        count = i;
    }

    public int getCount() {
        return count;
    }

    /**
     * 找到 p 位置的根节点的值
     * @param p
     * @return
     */
    private int root(int p){
        while (p != array[p]){
            p = array[p];// 例如： array[array[array[p]]]
        }
        return p;
    }


    /**
     * 联通x，y 即将y的根节点设为x的根节点的根节点
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        if(x < array.length && y < array.length){
            int i = root(x);
            int j = root(y);
            if(i == j){
                return;
            }
            array[i] = j;
            count--;//联通分量数量-1
        }
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


}
