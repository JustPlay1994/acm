package com.justplay1994.github.acm.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author huangzezhou
 * @date 2019/10/6
 * 5213. 玩筹码
 */


public class Solution5213 {

    class Solution {
        public int minCostToMoveChips(int[] chips) {
            int result = Integer.MAX_VALUE;
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < chips.length; i++){
                set.add(chips[i]);
            }
            for (Integer integer: set){
                int min = 0;
                for (int i = 0; i < chips.length; i++){
                    if ((chips[i] - integer) % 2 != 0){
                        min++;
                    }
                }
                result = result < min ? result : min;
            }
            return result;
        }
    }

}
