package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/11/25
 * 962. 最大宽度坡
 * start 15:35
 * ac 16:15
 */
/*

 */
public class Solution962 {

    class Solution {
        public int maxWidthRamp(int[] A) {
            int result = 0;
            for (int i = 0; i < A.length - 1; i++){
                for (int j = A.length - 1; j > i + result; j--){
                    if (A[i] <= A[j]){
                        result = Math.max(result, j - i);
                    }
                }
            }
            return result;
        }
    }

}
