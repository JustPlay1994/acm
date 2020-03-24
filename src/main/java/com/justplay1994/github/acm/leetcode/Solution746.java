package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/23
 * 746. 使用最小花费爬楼梯
 * start 16:21
 * ac 16:32
 */

public class Solution746 {

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length + 1];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i <= cost.length; i++){
                dp[i] = Math.min(dp[i - 1], dp[i - 2]);
                if (i < cost.length) {
                    dp[i] += cost[i];
                }
            }
            return dp[cost.length];
        }
    }

}
