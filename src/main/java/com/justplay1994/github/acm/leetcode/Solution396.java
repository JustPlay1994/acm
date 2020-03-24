package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/10
 * 396. 旋转函数
 * start 19:10
 * ac 19:33
 * one time
 */

public class Solution396 {
    class Solution {
        public int maxRotateFunction(int[] A) {
            int result = 0;
            int sum = 0;
            int temp = 0;
            int n = A.length;
            for (int i = 0; i < n; i++){
                sum += A[i];
                temp += i * A[i];
            }
            result = temp;
            for (int i = 1; i < n; i++){
                //F[i] =
                temp = temp - (n - 1) * A[n-i] + sum - A[n-i];
                result = Math.max(result, temp);
            }
            return result;
        }
    }
}
