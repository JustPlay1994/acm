package com.justplay1994.github.acm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 1296. 划分数组为连续数字的集合
 * start 16:40
 * ac 17:16
 */

public class Solution1296 {

    public static void main(String[] args){
        new Solution().isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4);
    }

    static
    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.merge(num, 1, (a, b) -> a + b);
            }
            List<Integer> list = map.keySet().stream().sorted().collect(Collectors.toList());
            for (Integer key : list) {
                Integer value = map.get(key);
                if (value != null && value > 0) {
                    for (int j = 1; j < k; j++) {
                        if (map.get(key + j) == null || map.get(key + j) < value) {
                            return false;
                        }
                        map.put(key + j, map.get(key + j) - value);
                    }
                }
            }
            return true;
        }
    }
}
