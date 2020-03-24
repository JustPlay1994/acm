package com.justplay1994.github.acm.leetcode;

import java.util.Arrays;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 917. 仅仅反转字母
 * start 10:45
 * ac 10:51
 */

public class Solution917 {

    class Solution {
        public String reverseOnlyLetters(String S) {
            StringBuilder result = new StringBuilder();
            char[] a = S.toCharArray();
            char[] b = new char[a.length];
            int size = 0;
            for (int i = 0; i < a.length; i++){
                if (('a'<=a[i] && a[i]<='z') || ('A'<=a[i] && a[i] <= 'Z') ){
                    b[size] = a[i];
                    size++;
                }
            }
            int j = size - 1;
            for (int i = 0; i < a.length; i++){
                if (('a'<=a[i] && a[i]<='z') || ('A'<=a[i] && a[i] <= 'Z') ){
                    result.append(b[j]);
                    j--;
                }else {
                    result.append(a[i]);
                }
            }
            return result.toString();
        }
    }

}
