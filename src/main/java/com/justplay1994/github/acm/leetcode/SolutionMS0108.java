package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 面试题 01.08. 零矩阵
 * start 16:20
 * ac 16:26
 */

public class SolutionMS0108 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            int[] row = new int[matrix.length];
            int[] col = new int[matrix[0].length];
            //标记法
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[i].length; j++){
                    if (matrix[i][j] == 0){
                        row[i] = 1;
                        col[j] = 1;
                    }
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(row[i] == 1 || col[j] == 1){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
