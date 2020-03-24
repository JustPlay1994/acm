package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 541. 反转字符串 II
 * start 17:29
 */

public class Solution541 {
    class Solution {
        public String reverseStr(String s, int k) {
            StringBuilder builder = new StringBuilder();
            char[] a = s.toCharArray();
            int i = 0;
            while (i < a.length){
                //reverse
                int temp = 0;
                int start = i;
                for (int j = Math.min(i + k - 1, a.length - 1); j >= start; j --){
                    if (temp == k) break;
                    builder.append(a[j]);
                    i++;
                    temp++;
                }

                temp = 0;
                for (; i < a.length; ){
                    if (temp == k) break;
                    builder.append(a[i]);
                    temp++;
                    i++;
                }
            }
            return builder.toString();
        }
    }
}
