package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2019/11/4
 * 674. 最长连续递增序列
 * start 17:17
 * end 17:30
 * 100 percent
 */

public class Solution674 {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return 1;
            int result = 1;
            int temp = 1;
            for (int i = 1; i < nums.length; i++){
                if (nums[i-1] < nums[i]){
                    temp++;
                }else {
                    result = result > temp ? result :temp;
                    temp = 1;
                }
            }
            result = result > temp ? result :temp;
            return result;
        }
    }
}
