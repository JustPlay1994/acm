package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/18
 * 836. 矩形重叠
 * start 15:38
 * ac
 */

public class Solution836 {

    /**
     * 判断点是否在矩形内
     */
    class Solution {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            return rec1[2] > rec2[0] && rec1[1] < rec2[3] && rec1[0] < rec2[2] && rec1[3] > rec2[1];
        }
    }
}
