package com.algorithm.leetcode;

/**
 * Created by Administrator
 * on 2017/7/14 9:23.
 *
 * 给定两个表示两个复数的字符串。您需要返回一个表示其乘法的字符串。
 */
public class P8ComplexNumberMultiplication {

    public static String complexNumberMultiply(String a, String b) {
        String result = "";
        int num = 0;
        int change = 0;
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        if(as.length == 2 && bs.length == 2){
            as[1] = as[1].substring(0,as[1].length() - 1);
            bs[1] = bs[1].substring(0,bs[1].length() - 1);
            try {
                num = Integer.parseInt(as[0]) * Integer.parseInt(bs[0])
                        - Integer.parseInt(as[1]) * Integer.parseInt(bs[1]);
                change = Integer.parseInt(as[0]) * Integer.parseInt(bs[1])
                        + Integer.parseInt(as[1]) * Integer.parseInt(bs[0]);
            } catch (NumberFormatException e){
                System.out.println("The input plural format is wrong!");
            }
            result = num + "+" + change + "i";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(P8ComplexNumberMultiplication.complexNumberMultiply("1+-1i", "2+5i"));
    }

}
