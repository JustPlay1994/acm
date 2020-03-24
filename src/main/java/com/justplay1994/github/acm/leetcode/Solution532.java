package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2019/11/23
 * 532. 数组中的K-diff数对
 * start 18:37
 * ac 19:10
 */

public class Solution532 {

    public static void main(String[] args){
        new Solution().findPairs(new int[]{6,2,9,3,9,6,7,7,6,4},3);
    }
    static
    class Solution {
        public int findPairs(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int result = 0;
            for (int i = 0; i < nums.length; i++){
                for (int j = i + 1; j < nums.length; j ++){
                    if (Math.abs(nums[i] - nums[j]) == k){
                        int min = Math.min(nums[i], nums[j]);
                        int max = Math.max(nums[i], nums[j]);
                        if (map.get(min) == null || map.get(min) != max){
                            result++;
                            map.put(min, max);
                        }
                    }
                }
            }
            return result;
        }
    }

}
