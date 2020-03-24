package com.justplay1994.github.acm.leetcode;

import java.util.*;

/**
 * @author huangzezhou
 * @date 2020/3/8
 * 37. 解数独
 * start 15:00
 * ac 11:00
 */

public class Solution37 {

    public static void main(String[] args){
        char[][] bord = new char[][]{
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };
        new Solution().solveSudoku(bord);
        System.out.println();
    }
    static
    class Solution {
        boolean isFinish = false;
        int[][] board;
        public void solveSudoku(char[][] board) {
            this.board = new int[9][9];
            //转int
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != '.') {
                        this.board[i][j] = board[i][j] - '0';
                    }else {
                        this.board[i][j] = board[i][j];
                    }
                }
            }
            int[] point = getNextPoint(this.board, -1, -1);
            recursive(this.board, point[0], point[1]);
            //拷贝答案
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = (char) (this.board[i][j] + '0');
                }
            }
        }

        public void recursive(int[][] board, int x, int y){

            if (isFinish)return;

            int[] temp = new int[10];
            Arrays.fill(temp, 1);
            //横向
            for (int i = 0; i < board.length; i++){
                if (board[x][i] != '.'){
                    temp[board[x][i]] = 0;
                }
            }
            //纵向
            for (int i = 0; i < board.length; i++){
                if (board[i][y] != '.'){
                    temp[board[i][y]] = 0;
                }
            }
            //九宫格
            for (int i = (x / 3) * 3; i < (x / 3 + 1) * 3; i++){
                for (int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++){
                    if (board[i][j] != '.'){
                        temp[board[i][j]] = 0;
                    }
                }
            }
            //尝试该点每一种可能
            for (int i = 1; i < temp.length; i++){
                if(isFinish) return;
                if (temp[i] != 1)continue;
//                int[][] array  = cloneArray(board);
                int[][] array = board;
                array[x][y] = i;
                //获取下一个空点
                int[] point = getNextPoint(array, x, y);
                if (point != null){
                    recursive(array, point[0], point[1]);
                }else {
                    isFinish = true;
                    this.board = array;
                    return;
                }
            }
            if(isFinish) return;
            //回滚
            board[x][y] = '.';
//            Formatter formatter = new Formatter();
//            System.out.println(formatter.format("x = %d, y = %d", x, y));
        }

        public int[][] cloneArray(int[][] board){
            int[][] board_clone = new int[board.length][board.length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board_clone[i][j] = board[i][j];
                }
            }
            return board_clone;
        }

        public int[] getNextPoint(int[][] board, int x, int y){
            boolean initial = false;
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[i].length; j++){
                    if ( !initial ) {
                        initial = true;
                        if (x != -1 && y != -1) {
                            i = x;
                            j = y;
                            continue;
                        }
                    }
                    if (board[i][j] == '.'){
                        return new int[]{i,j};
                    }
                }
            }
            return null;
        }
    }

}
