package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/9
 * 1006. 笨阶乘
 */

public class Solution1006 {

    public static void main(String[] args){
        new Solution().clumsy(10);
    }

    static class Solution {
        public int clumsy(int N) {
            int result = 0;
            boolean isFirst = true;
            int temp;
            while (true){
                temp = 0;
                if (N == 0) break;
                temp = N;
                N--;
                if (N == 0) break;
                temp *= N;
                N--;
                if (N == 0) break;
                temp /= N;
                N--;
                if (N == 0) break;
                result += N;
                N--;
                if (isFirst){
                    result += temp;
                    isFirst = false;
                }else {
                    result -= temp;
                }
            }
            if (isFirst){
                result += temp;
            }else {
                result -= temp;
            }
            return result;
        }
    }
}
