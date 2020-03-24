package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/8
 * 5353. 灯泡开关 III
 * start 10:39
 * ac 10:50
 */

public class Solution5353 {
    class Solution {
        public int numTimesAllBlue(int[] light) {
            int[] a = new int[light.length];
            int result = 0;
            int max = 0;
            for (int i = 0; i < light.length; i++){
                a[light[i] - 1] = 1;
                max = Math.max(light[i] - 1, max);
                boolean success = true;
                for (int j = 0; j < max; j++){
                    if (a[j] == 0){
                        success = false;
                        break;
                    }
                }
                if (success){
                    result++;
                }
            }
            return result;
        }
    }
}
