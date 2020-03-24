package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzezhou
 * @date 2019/12/7
 * 494. 目标和
 * dp训练
 * start 14:07
 * ac 15:12
 */

public class Solution494 {

    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            if (S > 1000 || S < -1000) return 0;
            if (nums.length == 0) return 0;
            int[][] dp = new int[nums.length][2001];
            dp[0][nums[0] + 1000] += 1;
            dp[0][1000 - nums[0]] += 1;
            for (int i = 1; i < nums.length; i++){
                for (int j = 0; j < dp[i].length; j++){
                    if (dp[i-1][j] > 0){
                        int value1 = j + nums[i];
                        dp[i][value1] += dp[i-1][j];
                        int value2 = j - nums[i];
                        dp[i][value2] += dp[i-1][j];
                    }
                }
            }
            return dp[nums.length - 1][S + 1000];
        }
    }

}
