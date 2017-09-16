package com.algorithm.algorithms.union_find;

/**
 * Created by HW
 * on 2017/7/14 22:13.
 * �ж϶�λ������a[n][m],a[i][j]�Ƿ���ͨ
 * ����unionд��
 */
public class QuickUnionUF {

    private int[] array; //�����ܼ��ϣ��Ƕ�λ������תΪһά����

    private int count; //��ͨ��������

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
     * �ҵ� p λ�õĸ��ڵ��ֵ
     * @param p
     * @return
     */
    private int root(int p){
        while (p != array[p]){
            p = array[p];// ���磺 array[array[array[p]]]
        }
        return p;
    }


    /**
     * ��ͨx��y ����y�ĸ��ڵ���Ϊx�ĸ��ڵ�ĸ��ڵ�
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
            count--;//��ͨ��������-1
        }
    }


    /**
     * �ж�x, y λ���Ƿ���ͨ����x,y�ĸ��ڵ�ֵ�Ƿ���ͬ
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
