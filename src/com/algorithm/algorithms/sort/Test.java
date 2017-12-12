package com.algorithm.algorithms.sort;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        /*//Example example = new SelectSort();
        //Example example = new InsertSort();
        Example example = new ShellSort();
        Double[] a = new Double[4000000];
        for(int i = 0; i < a.length; i++){
            a[i] = Math.random();
        }

        long start = System.currentTimeMillis();
        example.sort(a);
        long end = System.currentTimeMillis();
        //example.show(a);
        System.out.println(end - start);

        System.out.println(example.isSorted(a));*/
        String[] a = {"shell", "merge", "10000", "2000"};
        SortCompare.main(a);
    }

}
