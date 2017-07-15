package com.algorithm.algorithms.union_find;

/**
 * Created by Administrator
 * on 2017/7/14 21:44.
 */
public class QuickFindUF {

    private int[] array;

    public QuickFindUF(int i) {
        this.array = new int[i];
        for(int j = 0; j < i; j++){
            array[j] = j;
        }
    }

    /**
     * �ж�x��y�ڵ��Ƿ���ͨ
     * @param x ��Ϊ0
     * @param y ��Ϊ0
     * @return
     */
    public boolean connected(int x, int y){
        try{
            return array[x] == array[y];
        } catch (IndexOutOfBoundsException e){
            System.out.println("������ڵ��������ڵ�����");
            return false;
        }
    }

    public void union(int x, int y){
        int xid = array[x];
        int yid = array[y];
        for(int i = 0; i < array.length; i++){
            if(array[i] == xid){
                array[i] = yid;
            }
        }
    }
}
