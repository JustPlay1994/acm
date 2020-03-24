package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/11/4
 * 28. 实现 strStr()
 * start 16:30
 * ac 17:00
 */

public class Solution28 {

    public static void main(String[] args) throws Exception{

    }
static
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) return 0;

            char[] a = haystack.toCharArray();
            char[] b = needle.toCharArray();

             for (int i = 0; i < a.length; i++) {
                 if (a.length - i < b.length){
                     return -1;
                 }
                 if (a[i] == b[0]) {
                     int result = i;
                     for (int j = 0; j < b.length; j++) {
                         if (a[i+j] != b[j]) {
                             result = -1;
                             break;
                         }
                     }
                     if (result != -1) {
                         return i;
                     }
                 }
             }
            return -1;
        }
    }
}
