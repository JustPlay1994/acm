package com.justplay1994.github.acm.leetcode;

import java.util.*;

/**
 * 15. 三数之和
 * start 22:00
 *
 */
public class Solution15 {

    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> threeSum(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }

            for (int i = 0; i < nums.length; i++){
                for (int j = i + 1; j < nums.length; j++){
                    int value = nums[i] + nums[j];
                    value = -value;
                    int equalNum = 1;
                    if (value == nums[i]){
                        equalNum ++;
                    }
                    if (value == nums[j]){
                        equalNum ++;
                    }
                    if (map.get(value) != null && map.get(value) >= equalNum){
                        int biggest = Math.max(Math.max(nums[i], nums[j]), value);
                        int minest = Math.min(Math.min(nums[i], nums[j]), value);
                        String str = biggest+":"+minest;
                        if (!set.contains(str)){
                            set.add(str);
                            List<Integer> temp = new ArrayList<>();
                            temp.add(biggest);
                            temp.add(minest);
                            temp.add(-(biggest+minest));
                            result.add(temp);
                        }
                    }
                }
            }

            return result;
        }
    }

}
