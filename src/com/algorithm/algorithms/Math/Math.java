package com.algorithm.algorithms.Math;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator
 * on 2017/7/15 15:57.
 */
public class Math {

    public static int gcd(int x, int y){
        if(y == 0){
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static int abs(int x){
        if(x < 0){
            return -x;
        } else {
            return x;
        }
    }

    public static double abs(double x){
        if(x < 0.0){
            return -x;
        } else {
            return x;
        }
    }

    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        } else {
            for(int i = 2; i * i <= n; i++){
                if(n % i == 0){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 计算平方根
     * @param n
     * @param a
     * @return
     */
    public static double sqrt(double n, double a){
        if(n < 0.0){
            return Double.NaN;
        } else {
            double min = 0.0;
            double max = n;
            double mid = (min + max) / 2;
            double last = 0.0;
            do {
                if(mid * mid > n){
                    max = mid;
                } else {
                    min = mid;
                }
                last = mid;
                mid = (min + max) / 2;
            } while (java.lang.Math.abs(mid - last) > a);
            return mid;
        }
    }

    public static double sqrt(double n){
        if(n < 0.0){
            return Double.NaN;
        } else {
            double err = 1E-15;
            double t = n;
            while(java.lang.Math.abs(t - n/t) > err * t){
                t = (n/t + t) / 2.0;
            }
            return t;
        }
    }

    /**
     * 计算直角三角形斜边
     * @param a
     * @param b
     * @return
     */
    public static double hypotenuse(double a, double b){
        return java.lang.Math.sqrt(a * a + b * b);
    }

    public static int rank(int key, int[] a){
        return rank(key, a, 0, a.length-1);
    }

    /**
     * 二分查找法
     * @param key
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static int rank(int key, int[] a, int low, int high){
        if(low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if(key < a[mid]){
            high = mid;
            return rank(key, a, low, high-1);
        } else if (key > a[mid]){
            low = mid;
            return rank(key, a, low+1, high);
        } else {
            return a[mid];
        }
    }

    /**
     * 二分查找
     * @param key
     * @param a 从小到大有序数组
     * @return 数组内索引 -1即为不存在
     */
    public static int BinarySearch(int key, int[] a){
        int min = 0;
        int max = a.length - 1;
        while (min < max){
            int mid = min + max / 2;
            if(key > a[mid]){
                min = mid + 1;
            } else if (key < a[mid]) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(sc.next());
    }
}
