package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2019/11/3
 * 5247. 交换字符使得字符串相同
 */

public class Solution5247 {

    class Solution {
        public int minimumSwap(String s1, String s2) {
            if (s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()){
                return -1;
            }
            int num1 = 0;
            int num2 = 0;
            for (int i = 0; i < s1.length(); i++){
                if (s1.charAt(i) != s2.charAt(i)){
                    if (s2.charAt(i) == 'x'){
                        num1 ++;
                    }else {
                        num2 ++;
                    }
                }
            }
            if( (num1 % 2 + num2 % 2) % 2 !=0){
                return -1;
            }
            return num1 / 2 + num2 / 2 + (num1 % 2 + num2 % 2) / 2;
        }
    }
}
