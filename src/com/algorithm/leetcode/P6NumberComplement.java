package com.algorithm.leetcode;

/**
 * Created by Administrator
 * on 2017/7/13 19:29.
 */
public class P6NumberComplement {

    public static int findComplement(int num) {
        int result = 0;
//        Long bit = Long.highestOneBit(num);
//        int total = 1;
//        for(int i = 1; i < bit; i++){
//            total += Math.pow(2, i);
//        }
//        result = total ^ num;
        return result;
    }

    public static int findComplement1(int num) {
        int i = 0;
        int j = 0;

        while( i < num){
            i += Math.pow(2, j);
            j++;
        }

        return i - num;
    }

    public static void main(String[] args) {

        System.out.println(P6NumberComplement.findComplement(16));

    }

}
