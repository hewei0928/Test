package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator
 * on 2017/7/12 16:07.
 */
public class P1TwoSum {

    public static int[] twoSums(int[] nums, int target){
        int[] result = new int[2];
        breakFor: for(int i = 0; i < nums.length; i++ ){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break breakFor;
                }
            }
        }
        return result;
    }

    public static int[] twoSums2(int[] nums, int target){
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = hashMap.get(target - nums[i]);
                break;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(P1TwoSum.twoSums2(new int[]{1,4,5,9,3}, 4)[0]);

    }

}
