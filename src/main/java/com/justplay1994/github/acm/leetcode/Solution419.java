package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/12/9
 * 419. 甲板上的战舰
 * ac
 */

public class Solution419 {

    class Solution {
        public int countBattleships(char[][] board) {
            int result = 0;
            if (board.length == 0) return result;
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[i].length; j++){
                    if (board[i][j] != 'X') continue;
                    boolean add = true;
                    if (i > 0){
                        if (board[i-1][j] == 'X'){
                            add = false;
                        }
                    }
                    if (j > 0){
                        if (board[i][j-1] == 'X'){
                            add = false;
                        }
                    }
                    if (add){
                        result++;
                    }
                }
            }
            return result;
        }
    }

}
