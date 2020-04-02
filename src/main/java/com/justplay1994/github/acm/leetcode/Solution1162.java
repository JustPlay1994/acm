package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/29
 * 1162. 地图分析
 * start 11:03
 * ac 12:00
 */

public class Solution1162 {
    class Solution {
        //===扩图法
        //方法一：遍历每一块大陆，往外吧所有0都填充完，里面存放距离+1。如果已经有距离，就放最小值。
        //方法二：每次都让每块大陆往外扩展一格，最后填充完后，得到最大值。

        //回溯,其实也是把空格当成图往外扩
        //方法三：计算每一个空格的最小值，每一个空格需要遍历+剪枝（1.如果不可能更大则返回，2.当前空格如果已经获取最小值，则进行下一个点）
        public int maxDistance(int[][] grid) {

            int k = 1;
            boolean change = true;
            while (change && k <= (grid.length - 1) * (grid.length - 1)){
                change = false;
                for (int i = 0; i < grid.length; i++){
                    for (int j = 0; j < grid[i].length; j++){
                        if (grid[i][j] == k){
                            if (i > 0){
                                if (grid[i-1][j] == 0){
                                    grid[i-1][j] = k + 1;
                                    change = true;
                                }else {
                                    grid[i - 1][j] = Math.min(grid[i - 1][j], k + 1);
                                    change = true;
                                }
                            }
                            if (i < grid.length - 1){
                                if (grid[i+1][j] == 0) {
                                    grid[i+1][j] = k + 1;
                                    change = true;
                                }else {
                                    grid[i + 1][j] = Math.min(grid[i + 1][j], k + 1);
                                    change = true;
                                }
                            }
                            if (j > 0){
                                if ( grid[i][j-1] == 0) {
                                    grid[i][j - 1] = k + 1;
                                    change = true;
                                }else {
                                    grid[i][j - 1] = Math.min(grid[i][j - 1], k + 1);
                                    change = true;
                                }
                            }
                            if (j < grid[i].length - 1){
                                if (grid[i][j+1] == 0){
                                    grid[i][j+1] = k + 1;
                                    change = true;
                                }else {
                                    grid[i][j + 1] = Math.min(grid[i][j + 1], k + 1);
                                    change = true;
                                }
                            }
                        }
                    }
                }
                k++;
            }
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    result = Math.max(result, grid[i][j]);
                }
            }
            return result - 1 == 0 ? -1 : result - 1;
        }
    }
}
