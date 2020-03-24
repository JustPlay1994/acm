package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/11/25
 * 463. 岛屿的周长
 * start 15:23
 * ac 15:31
 */

public class Solution463 {

    class Solution {
        public int islandPerimeter(int[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[i].length; j++){
                    if (grid[i][j] == 0) continue;
                    //上
                    if (i == 0){
                        result++;
                    }else {
                        if (grid[i-1][j] == 0){
                            result++;
                        }
                    }
                    //下
                    if (i == grid.length - 1){
                        result++;
                    }else {
                        if (grid[i+1][j] == 0){
                            result++;
                        }
                    }
                    //左
                    if (j == 0){
                        result++;
                    }else {
                        if (grid[i][j-1] == 0){
                            result++;
                        }
                    }
                    //右
                    if (j == grid[i].length - 1){
                        result++;
                    }else {
                        if (grid[i][j+1] == 0){
                            result++;
                        }
                    }
                }
            }
            return result;
        }
    }

}
