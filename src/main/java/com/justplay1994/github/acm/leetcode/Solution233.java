package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/25
 * 233. 数字 1 的个数
 * start: 10:48
 * pause: 10:51
 * start: 10:55
 * pause: 10:56
 * start: 11:00
 * pause: 11:27
 * start: 14:11
 */

public class Solution233 {


    class Solution {
        int max;
        public int countDigitOne(int n) {
            this.max = n;
            return n;
        }

        /**
         * 这个几位数，1出现的个数是多少。 111,112 就是5个
         * @param i 最大位数
         * @return
         */
        public int a(int i){
            int result = 0;
            //情况1: 1开头
            //去掉1 剩余 位数
            int otherB = getB(max) - 1;
            result += square(10, otherB) - b(getB( otherB));
            //情况2：不是1开头



            return 0;
        }

        /**
         * 这个几位数，包含1的数字，有多少个。  111， 112 就是2个
         * @param i 最大位数
         * @return
         */
        public int b(int i){
            return 0;
        }

        /**
         * 去掉最高位
         * @param input
         * @return
         */
        public int deletFirst(int input){
            int temp = input;
            return 0;
        }

        /**
         * 计算位数
         * @param input
         * @return
         */
        public int getB(int input){
            int temp = input;
            return 0;
        }

        /**
         * 获取当前位最大值 9999。。 n个
         * @param input 位数
         * @return
         */
        public int getBMax(int input){

            return 0;
        }

        /**
         * 计算次方
         * @param input 底数
         * @param num 幂
         * @return
         */
        public int square(int input, int num){
            int temp = input;
            return 0;
        }
    }

}
