package com.justplay1994.github.acm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 面试题 16.11. 跳水板
 */

public class SolutionMS1611 {

    class Solution {
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) return new int[0];
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i <= k; i++){
                set.add(shorter*i + longer*(k-i));
            }
            List<Integer> list = set.stream().sorted().collect(Collectors.toList());
            int[] result = new int[list.size()];
            for (int i = 0; i < result.length; i++){
                result[i] = list.get(i);
            }
            return result;
        }
    }
}
