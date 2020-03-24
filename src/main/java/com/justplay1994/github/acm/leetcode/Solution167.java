package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2020/3/18
 * 167. 两数之和 II - 输入有序数组
 * start 17:15
 *
 */

public class Solution167 {

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            HashMap<Integer, Integer> map = new HashMap();
            for (int i = 0;i < numbers.length; i++){
                if (map.get(numbers[i]) != null){
                    return new int[] { Math.min(i+1, map.get(numbers[i])+1), Math.max(i+1, map.get(numbers[i])+1)};
                }else {
                    map.put(target - numbers[i], i);
                }
            }
            return null;
        }
    }

}
