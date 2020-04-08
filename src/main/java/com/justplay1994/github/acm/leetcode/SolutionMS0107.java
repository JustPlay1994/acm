package com.justplay1994.github.acm.leetcode;

/**
 * Created by huangzezhou
 * Date: 2020/4/7
 * Time: 18:37
 * 面试题 01.07. 旋转矩阵
 * ac 20:05
 **/
public class SolutionMS0107 {
    public static void main(String[] args){
        new Solution().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    static
    class Solution {
        //遍历四分之一个数组，每遍历一个点，则进行一周旋转
        public void rotate(int[][] matrix) {
            if (matrix.length < 2)return;
            int n = matrix.length;
            for (int i = 0; i < (n + 1) / 2; i++){
                for (int j = 0; j < n / 2; j++){
                    int last;
                    int value;
                    //右上侧
                    value = matrix[j][n-1-i];
                    matrix[j][n-1-i] = matrix[i][j];
                    //右下
                    last = value;
                    value = matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j] = last;
                    //左下
                    last = value;
                    value = matrix[n-1-j][i];
                    matrix[n-1-j][i] = last;
                    //左上
                    matrix[i][j] = value;
                }
            }

        }
    }
}
