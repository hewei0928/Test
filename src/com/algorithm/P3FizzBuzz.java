package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator
 * on 2017/7/13 10:11.
 */
public class P3FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String s = "";
            if(i % 3 == 0){
                s += "Fizz";
            }
            if(i % 5 == 0){
                s += "Buzz";
            }
            if(s.equals("")){
                s = String.valueOf(i);
            }
            result.add(s);
        }

        return  result;
    }

    public static void main(String[] args) {
        List<String> list = P3FizzBuzz.fizzBuzz(34);
        for(String s : list){
            System.out.println(s);
        }
    }

}
