package com.justplay1994.github.acm.leetcode;

/**
 * 2020/05/15 16:46
 * 896. 单调数列
 * 16:51
 */
public class Solution896 {

    class Solution {
        public boolean isMonotonic(int[] A) {
            if (A.length <= 1) return true;
            int sign = 0;
            for (int i = 1 ; i < A.length; i++){
                int temp = A[i] - A[i-1];
                if (temp > 0){
                    if (sign == 0){
                        sign = 1;
                    }
                    if (sign < 0){
                        return false;
                    }
                }else if (temp < 0){
                    if (sign == 0){
                        sign = -1;
                    }
                    if (sign > 0){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
