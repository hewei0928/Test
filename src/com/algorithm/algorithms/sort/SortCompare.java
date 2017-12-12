package com.algorithm.algorithms.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

    public static double time(String alg, Double[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("select")){
          new SelectSort().sort(a);
        }
        if(alg.equals("insert")){
            new InsertSort().sort(a);

        }
        if(alg.equals("shell")){
            new ShellSort().sort(a);
        }
        if(alg.equals("merge")){
            new MergeSort().sort(a);
        }
        return timer.elapsedTime();
    }

    /**
     * 使用算法alg 将t个长度为n的数组排序
     * @param alg
     * @param n
     * @param t
     * @return
     */
    public static double timeRandomInput(String alg, int n, int t){
        double total = 0.0;
        Double[] a = new Double[n];
        for (int i = 0; i < t; i++){
            for(int j = 0; j < n; j++){
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args){
        String alg1 = args[0];
        String alg2 = args[1];
        int n = Integer.parseInt((args[2]));
        int t = Integer.parseInt((args[3]));
        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);
        StdOut.printf("For %d random Doubles\n  %s is", n, alg1);
        StdOut.printf("%.1f time faster than %s\n", t2/t1, alg2);
    }
}
