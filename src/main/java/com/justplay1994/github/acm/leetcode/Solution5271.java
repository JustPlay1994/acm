package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/11/24
 * 5271. 访问所有点的最小时间
 * start 10:37
 * ac
 */

public class Solution5271 {
    class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            int result = 0;
            if (points.length == 0) return result;
            int[] last = points[0];
            for(int i = 1; i < points.length; i++){
                int x = Math.abs(points[i][0] - last[0]);
                int y = Math.abs(points[i][1] - last[1]);
                result += Math.max(x, y);
                last = points[i];
            }
            return result;
        }
    }
}
