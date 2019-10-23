package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/23
 * 374. 猜数字大小
 * start 21:00
 * ac 21:22
 * One time
 */

public class Solution374 {

    class GuessGame{
        public int guess(int n) {
            return 0;
        }
    }

    public class Solution extends GuessGame {
        public int guessNumber(int n) {

            int max = Integer.MAX_VALUE;
            if (super.guess(max) == 0){
                return max;
            }
            int min = 1;
            int current = max / 2;
            int temp = 1;
            while (temp != 0){
                temp = super.guess(current);
                if (temp == -1){
                    max = current;
                }else if (temp == 1) {
                    min = current;
                }
                current = min + (max - min) / 2;
            }
            return current;
        }
    }

}
