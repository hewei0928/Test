package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator
 * on 2017/7/17 13:49.
 * �����������������k���ҳ��������Ƿ���������ͬ������i��j��
 * ʹ��nums [i] = nums [j]��i��j֮��ľ��Բ�ֵ���Ϊk��
 */
public class P12ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) {
                if (hashMap.containsKey(nums[i]) && (i - map.get(nums[i])) > hashMap.get(nums[i])) {
                    hashMap.put(nums[i], i - nums[i]);
                } else if( !hashMap.containsKey(nums[i]) ) {
                    hashMap.put(nums[i], 0);
                }
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }

        for(Integer i : hashMap.values()){
            if(i <= k){
                return true;
            }
        }
        return false;
    }
}
