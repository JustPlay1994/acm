package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzezhou
 * @date 2019/12/7
 * 413. 等差数列划分
 * dp训练
 * start 10:41
 * ac 11:31
 * one time
 */

public class Solution413 {

    public static void main(String[] args){
        new Solution().numberOfArithmeticSlices(new int[]{1,2,3,4});
    }

    static
    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int result = 0;
            HashMap<Integer,Integer>[] dp = new HashMap[A.length];   //等差数列结尾下标，等差值，等差数列长度
            for (int i = 0; i < A.length; i++){
                dp[i] = new HashMap();
                dp[i].put(0, 1);
            }
            for (int i = 1; i < A.length; i++){
                int d = A[i] - A[i - 1];
                int n = zero(dp[i-1].get(d)) + 1;
                dp[i].put(d, n);
                if (n > 2){
                    result += n - 2;
                }
            }
            return result;
        }
        private int zero(Integer o){
            if (o == null)return 1;
            return o;
        }

    }
}
