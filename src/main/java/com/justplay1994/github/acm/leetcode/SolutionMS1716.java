package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/24
 * 面试题 17.16. 按摩师
 */

public class SolutionMS1716 {

    class Solution {
        public int massage(int[] nums) {
            int[] dp = new int[nums.length];
            if (nums.length == 0) return 0;
            dp[0] = nums[0];
            if (nums.length > 1){
                dp[1] = Math.max(nums[0], nums[1]);
            }
            for (int i = 2; i < nums.length; i ++){
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }
}
