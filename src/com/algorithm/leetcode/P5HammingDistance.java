package com.algorithm.leetcode;

/**
 * Created by Administrator
 * on 2017/7/13 10:33.
 */
public class P5HammingDistance {

    public static int getInstance(int x, int y){
        int result = 0;
        int i = x & y;
        int j = x | y;
        int k = j - i;
        while(k != 0){
            int l = k % 2;
            if(l != 0){
                result += 1;
            }
            k /= 2;
        }
        return  result;
    }

    public static int getInstance1(int x, int y){
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(P5HammingDistance.getInstance(4, 5));
    }

}
