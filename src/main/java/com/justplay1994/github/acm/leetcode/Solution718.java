package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/31
 * 718. 最长重复子数组
 * start 16:23
 * end 17:07
 * one time
 */

public class Solution718 {

    class Solution {
        public int findLength(int[] A, int[] B) {
            int result = 0;
            if (A.length == 0 || B.length == 0) return 0;
            int[][] dp = new int[A.length][B.length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = A[i] == B[j] ? 1 : 0;
                    }else {
                        dp[i][j] = A[i] == B[j] ? dp[i - 1][j - 1] + 1 : 0;
                    }
                    result = result > dp[i][j] ? result : dp[i][j];
                }
            }
            return result;
        }
    }
}
