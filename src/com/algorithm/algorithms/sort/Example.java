package com.algorithm.algorithms.sort;

/**
 * 排序类模板接口
 */
public abstract class Example {

    abstract void sort(Comparable[] a);

    boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    /**
     * 交换i,j 位置处数据
     * @param a
     * @param i
     * @param j
     */
    void exchange(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印输出
     * @param a
     */
    void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
    }

    /**
     * 判断是否有序
     * @param a
     * @return
     */
    boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            if(less(a[i], a[i - 1])){
                return false;
            }
        }

        return true;
    }

}
