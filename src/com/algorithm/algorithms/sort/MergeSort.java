package com.algorithm.algorithms.sort;

public class MergeSort extends Example {

    private static Comparable[] aux;


    @Override
    void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        //自顶向下归并
        /*sort(a, 0, a.length - 1);*/

        //自底向上归并
        for(int i = 0; i < a.length; i *= 2){
            for(int j = 0; j < a.length - i; j += i*2){
                merge(a, j, j + i - 1, Math.min(j + i + i - 1, a.length - 1));
            }
        }
    }

    public void sort(Comparable[] a, int low, int high){
        if(low >= high){
            return;
        }

        int mid = (low + high)/2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public void merge(Comparable[] a, int low, int mid, int high){
        int i = low, j = mid + 1;
        for(int k = low; k <= high; k++){
            aux[k] = a[k];
        }

        for(int k = low; k <= high; k++){
            if(i > mid){
                a[k] = aux[j++];
            } else if(j > high){
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])){
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
}
