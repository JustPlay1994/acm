package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 面试题10- I. 斐波那契数列
 * start 15:36
 * ac 16:08
 */

public class SolutionMS101 {

    class Solution {
        public int fib(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            int a1 = 1;
            int a2 = 1;
            for (int i = 3; i <= n; i++){
                int temp = a1;
                a1 = (a1 + a2) % 1000000007;
                a2 = temp;
            }
            return a1 % 1000000007;
        }
    }

}
