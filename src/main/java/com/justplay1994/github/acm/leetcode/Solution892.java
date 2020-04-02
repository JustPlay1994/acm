package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/25
 * 892. 三维形体的表面积
 * start 9:24
 * ac 9:50
 */

public class Solution892 {

    class Solution {
        public int surfaceArea(int[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[i].length; j++){
                    if (grid[i][j] == 0) continue;
                    result += (grid[i][j] << 2) + 2;
                    if (i > 0){
                        result -= Math.min(grid[i-1][j], grid[i][j]) << 1;
                    }
                    if (j > 0){
                        result -= Math.min(grid[i][j-1], grid[i][j]) << 1;
                    }
                }
            }
            return result;
        }
    }

}
