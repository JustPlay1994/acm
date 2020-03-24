package com.justplay1994.github.acm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huangzezhou
 * @date 2019/10/25
 * 453. 最小移动次数使数组元素相等
 * start 17:03
 * pause 17:30
 * start 22:19
 * start 2019/12/09 15:36
 * ac 14:40
 */

public class Solution453 {

    class Solution {
        public int minMoves(int[] nums) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++){
                min = min < nums[i] ? min : nums[i];
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++){
                result += nums[i] - min;
            }
            return result;
        }
    }

}
