package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/8
 * 5352. 生成每种字符都是奇数个的字符串
 * start 10:32
 * end 10:39
 * one time
 */

public class Solution5352 {

    class Solution {
        public String generateTheString(int n) {
            StringBuilder result = new StringBuilder();
            char a = 'a';
            if(n % 2 ==0){
                for (int i = 0; i < n - 1; i++){
                    result.append("a");
                }
                result.append("b");
            }else {
                for (int i = 0; i < n; i++){
                    result.append("a");
                }
            }
            return result.toString();
        }
    }

}
