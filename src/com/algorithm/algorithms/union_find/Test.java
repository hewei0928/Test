package com.algorithm.algorithms.union_find;

/**
 * Created by Administrator
 * on 2017/7/14 21:56.
 */
public class Test {

    private static void testQuickFindUF(){
        QuickFindUF quickFindUF = new QuickFindUF(20000000);
        Long start = System.currentTimeMillis();
        quickFindUF.union(1, 2);
        quickFindUF.union(6, 2);
        quickFindUF.union(7, 2);
        quickFindUF.union(9, 1);
        quickFindUF.union(8, 3);
        quickFindUF.union(11, 9);
        System.out.println(quickFindUF.connected(11, 2));
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void testQuickUnionUF(){
        QuickUnionUF quickUnionUF = new QuickUnionUF(20000000);
        Long start = System.currentTimeMillis();
        quickUnionUF.union(1, 2);
        quickUnionUF.union(6, 2);
        quickUnionUF.union(7, 2);
        quickUnionUF.union(9, 1);
        quickUnionUF.union(8, 3);
        quickUnionUF.union(11, 9);
        System.out.println(quickUnionUF.connected(11, 2));
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        testQuickFindUF();
        testQuickUnionUF();
    }
}
