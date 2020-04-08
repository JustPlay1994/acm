package com.justplay1994.github.acm.leetcode;

/**
 * Created by huangzezhou
 * Date: 2020/4/8
 * Time: 18:38
 * 面试题13. 机器人的运动范围
 * ac 20:18
 **/
public class SolutionMS13 {


    public static void main(String[] args){
        System.out.println(new Solution().movingCount(16,8,4));
    }

    static
    class Solution {
        int m,n,k;
        int result = 0;
        int[][] a;
        //染色法
        public int movingCount(int m, int n, int k) {
            this.m = m; this.n = n; this.k = k;
            a = new int[m][n];
            //DFS
            recursive(0,0);
            return result;
        }
        private void recursive(int i, int j){
            if (sum(i) + sum(j) > k
                    || i >= m
                    || i < 0
                    || j >= n
                    || j < 0
                    || a[i][j] == 1)
                return;
            result++;
            a[i][j] = 1;
            recursive(i+1, j);
            recursive(i, j+1);
            recursive(i - 1, j);
            recursive(i, j - 1);
        }

        private int sum(int val){
            int result = 0;
            result += val % 10;
            while ((val = val / 10) > 0){
                result += val % 10;
            }
            return result;
        }
    }

}
