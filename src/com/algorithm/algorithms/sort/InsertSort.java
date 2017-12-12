package com.algorithm.algorithms.sort;

/**
 * 插入排序  对部分有序数组十分有效
 */
public class InsertSort extends Example{

    @Override
    void sort(Comparable[] a) {
        int l= a.length;
        for(int i = 0; i < l; i ++){
            /*for(int j = i; j > 0; j --){
                if(less(a[i], a[j])){
                    exchange(a, i, j);
                }
            }*/

            //for循环条件添加，大大提高算法效率
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j --){
                exchange(a, j, j - 1);
            }


            //改进版， 把较大数右移，减少一半数组访问时间
            /*int min = i;
            for(int j = i - 1; j >= 0 && less(a[i], a[j]); j--){
                min = j;
            }
            if( min != i){
                Comparable temp = a[i];
                for(int k = i; k > min; k--){
                    a[k] = a[k - 1];
                }
                a[min] = temp;
            }*/
        }
    }
}
