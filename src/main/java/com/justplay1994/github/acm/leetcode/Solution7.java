package com.justplay1994.github.acm.leetcode;

/**
 * 2020/05/15 19:52
 * 7. 整数反转
 */
public class Solution7 {

    public int reverse(int x) {
        long result = 0;
        int left = x;
        while (left != 0){
            result = result * 10 + left % 10;
            left = left / 10;
        }
        if (result > Integer.MAX_VALUE && result < Integer.MIN_VALUE) return 0;
        return new Long(result).intValue();
    }

}
