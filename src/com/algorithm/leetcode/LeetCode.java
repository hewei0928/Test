package com.algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by Administrator
 * on 2017/7/17 19:31.
 */
public class LeetCode {

    /**
     * 计算二和
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 计算二和
     * @param nums
     * @param target
     * @return
     */
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

}
