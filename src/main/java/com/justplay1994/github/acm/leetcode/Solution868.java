package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 868. 二进制间距
 * start 10:11
 * ac 10:31
 */

public class Solution868 {

    class Solution {
        public int binaryGap(int N) {
            int temp = N;
            while (true){
                if (temp % 2 == 1 || temp == 0){
                    break;
                }
                temp = temp >> 1;
            }
            int result = 0;
            int number = 0;
            int mod;
            while (( temp = temp >> 1) > 0){
                mod = temp % 2;
                number ++;
                if (mod == 1){
                    result = Math.max(result, number);
                    number = 0;
                }
            }
            return result;
        }
    }

}
