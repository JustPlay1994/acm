package com.justplay1994.github.acm.leetcode;

/**
 * 20200515 15:40
 * 560. 和为K的子数组
 * ac : 16:30
 */
public class Solution560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int result = 0;
            if (nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            int temp = 0;
            for (int i = 0; i < nums.length; i++){
                temp += nums[i];
                dp[i] = temp;
            }
            for (int i = 0; i < nums.length; i++){
                for (int j = i; j < nums.length; j++){
                    if (i == 0){
                        if (dp[j] == k){
                            result++;
                        }
                    }else if (dp[j] - dp[i - 1] == k){
                        result++;
                    }
                }
            }
            return result;
        }
    }
}
