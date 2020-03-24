package com.justplay1994.github.acm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2019/11/9
 * 1027. 最长等差数列
 * start 11:27
 * 100 percent
 */

public class Solution1027 {

    class Solution {
        /*
        dp[i][d] 表示 i结尾，等差为d，数列的最长值。
         */
        public int longestArithSeqLength(int[] A) {
            int result = 0;
            if (A.length == 0) {
                return 0;
            }
            int[][] dp = new int[A.length][20003];
            for (int i = 1; i < A.length; i++){
                for (int j = 0; j < i; j++){
                    int d = A[j] - A[i] + 10001;
                    if (dp[j][d] == 0){
                        dp[i][d] = 2;
                    }else {
                        dp[i][d] = dp[j][d] + 1;
                    }
                    result = result > dp[i][d] ? result : dp[i][d];
                }
            }
            return result;
        }

    }

}
