package com.algorithm.algorithms.union_find;

/**
 * Created by HW
 * on 2017/7/14 21:44.
 * 判断二位数组中a[n][m],a[i][j]是否联通
 * 快速find写法 union方法将一个数组连接至只有一个联通分量，时间复杂度为n^2;
 */
public class QuickFindUF {

    private int[] array; //样本总集合，是二位数组则转为一维数组

    private int count; //联通分量数量

    public QuickFindUF(int i) {
        this.array = new int[i];
        for(int j = 0; j < i; j++){
            array[j] = j;
        }
        count = i;
    }

    /**
     * 使x,y位置互通, 即使x,y处值相同
     * @param x
     * @param y
     */
    public void union(int x, int y){
        if( x < array.length && y < array.length) {
            int xid = find(x);
            int yid = find(y);

            if (yid == xid) return;//如果两个位置值相同表示已联通，无需继续操作

            for (int i = 0; i < array.length; i++) {
                if (array[i] == xid) {
                    array[i] = yid;
                }
            }
            count--;//连通后联通分量数量-1
        }
    }

    /**
     * 返回x位置的值
     * @param x
     * @return
     */
    private int find(int x){
        return array[x];
    }

    /**
     * 判断x, y是否联通
     * @param x
     * @param y
     * @return
     */
    public boolean connected(int x, int y){
        try {
            return array[x] == array[y];
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }
}
