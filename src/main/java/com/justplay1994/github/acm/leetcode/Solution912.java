package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/31
 * 912. 排序数组
 * start 10:58
 * ac 11:15
 */

public class Solution912 {
    class Solution {
        public int[] sortArray(int[] nums) {

            int[] result = new int[nums.length];
            if (nums.length == 0){
                return result;
            }
            int[] sort = new int[100001];
            for (int num : nums) {
                sort[num + 50000]++;
            }
            int j = 0;
            for (int i = 0; i < sort.length; i ++){
                if (j >= nums.length) break;
                for (int k = 0; k < sort[i]; k++){
                    result[j] = i - 50000;
                    j++;
                }
            }
            return result;
        }
    }
}
