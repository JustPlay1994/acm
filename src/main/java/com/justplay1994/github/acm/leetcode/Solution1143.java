package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/7
 * 1143. 最长公共子序列
 * start 16:26
 * ac 17:00
 * one time
 */

public class Solution1143 {

    public static void main(String[] args){
        new Solution().longestCommonSubsequence("abcde", "ace");
    }

    static
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int result = 0;
            if (text1 == null || text2 == null){
                return result;
            }
            char[] array1 = text1.toCharArray();
            char[] array2 = text2.toCharArray();

            if (array1.length < 1 || array2.length < 1){
                return result;
            }
            int[][] dp = new int[array1.length][array2.length];
            dp[0][0] = array1[0] == array2[0] ? 1 : 0;

            for (int i = 1; i < array1.length; i++){
                if (dp[i - 1][0] == 1 || array1[i] == array2[0]){
                    dp[i][0] = 1;
                }
            }
            for (int j = 1; j < text2.length(); j++){
                if (dp[0][j - 1] == 1 || array1[0] == array2[j]){
                    dp[0][j] = 1;
                }
            }

            for(int i = 1; i < text1.length(); i++){
                for(int j = 1; j < text2.length(); j++){
                    //比较三种情况：[i-1,j], [i,j-1], [i,j]
                    dp[i][j] = array1[i] == array2[j] ? dp[i-1][j-1]+1 : dp[i-1][j-1];
                    int temp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.max(dp[i][j], temp);
                    result = Math.max(result, dp[i][j]);
                }
            }
            return result;
        }
    }

}
