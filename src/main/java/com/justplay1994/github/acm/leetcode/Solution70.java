package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/23
 * 70. 爬楼梯
 * start 16:15
 * ac 16:20
 */

public class Solution70 {
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
