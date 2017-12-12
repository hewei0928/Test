package com.algorithm.algorithms.sort;

/**
 * 选择排序
 */
public class SelectSort extends Example{

    @Override
    void sort(Comparable[] a) {
        for(int i = 0; i < a.length; i++){
            int min = i;
            //找出最小数并与下标为i的数对换
            for(int j = i + 1; j < a.length; j++){
                if(a[j].compareTo(a[min]) < 0)
                    min = j;
            }
            exchange(a, i , min);
        }
    }


}
