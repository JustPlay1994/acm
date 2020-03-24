package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/23
 * 面试题 08.01. 三步问题
 * start 17:21
 * ac 17:35
 */

public class SolutionMS0801 {

    class Solution {
        public int waysToStep(int n) {
            if (n == 0) return 0;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            if (n >= 1) {
                dp[1] = 1;
            }
            if (n >= 2) {
                dp[2] = 2;
            }
            for (int i = 3; i <= n; i++){
                dp[i] = ((dp[i - 1] + dp[i-2]) % 1000000007 + dp[i-3]) % 1000000007;
            }
            return dp[n];
        }
    }

}
