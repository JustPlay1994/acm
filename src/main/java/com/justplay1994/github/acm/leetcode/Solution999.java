package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/26
 * 999. 车的可用捕获量
 * start 9:15
 * ac 9:40
 */
// “R”，“.”，“B” 和 “p”
public class Solution999 {
    class Solution {
        public int numRookCaptures(char[][] board) {
            if (board.length == 0)return 0;
            int result = 0;
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[i].length; j++){
                    if (board[i][j] == 'R'){
                        //纵向
                        int temp=0;
                        for (int r = 0; r < i; r++){
                            if (board[r][j] == 'p'){
                                temp++;
                            }
                            if (board[r][j] == 'B'){
                                temp = 0;
                            }
                        }
                        result += temp > 0 ? 1 : 0;
                        for (int r = i; r < board.length; r++){
                            if (board[r][j] == 'p'){
                                result+=1;
                                break;
                            }
                            if (board[r][j] == 'B') break;
                        }
                        //横向
                        temp = 0;
                        for (int c = 0; c < j; c++){
                            if (board[i][c] == 'p'){
                                temp++;
                            }
                            if (board[i][c] == 'B'){
                                temp = 0;
                            }
                        }
                        result += temp > 0 ? 1 : 0;
                        for (int c = j; c < board[i].length; c++){
                            if (board[i][c] == 'p'){
                                result+=1;
                                break;
                            }
                            if (board[i][c] == 'B') break;
                        }
                    }
                }
            }
            return result;
        }
    }
}
