package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2019/11/24
 * 5272. 统计参与通信的服务器
 * start 10:44
 * ac
 */

public class Solution5727 {

    public static void main(String[] args){
        new Solution().countServers(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}});
    }
    static
    class Solution {
        public int countServers(int[][] grid) {
            int result = 0;
            if (grid.length ==0 || grid[0].length == 0)return 0;
            int[] row = new int[grid.length];
            int[] cols = new int[grid.length];
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[i].length; j++){
                    if (grid[i][j] == 1){
                        row[i]++;
                        cols[i] = j;
                        result++;
                    }
                }
            }
            for (int i = 0; i < row.length; i++){
               if (row[i] == 1){
                   int col = 0;
                   for (int j = 0; j < grid.length; j++){
                       if (grid[j][cols[i]] == 1){
                            col++;
                            if (col > 1)break;
                       }
                   }
                   if (col == 1){
                       result --;
                   }
               }
            }

            return result;
        }
    }

}
