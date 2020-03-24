package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/23
 * 面试题42. 连续子数组的最大和
 * start 17:36
 * ac 18:22
 */

public class SolutionMS42 {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0) return 0;
            int result = nums[0];
            int temp = 0;
            for (int num : nums) {
                if (temp < 0){
                    temp = num;
                }else {
                    temp += num;
                }
                result =result > temp ? result : temp;
            }
            return result;
        }
    }
}
