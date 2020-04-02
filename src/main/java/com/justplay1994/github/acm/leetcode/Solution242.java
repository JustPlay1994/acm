package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2020/3/28
 * 242. 有效的字母异位词
 * start 12:04
 */

public class Solution242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()){
                return false;
            }
            if (s.length() == 0 ){
                return true;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            char[] a1 = s.toCharArray();
            char[] a2 = t.toCharArray();
            for (char c: a1){
                map.merge((int)c, 1, (a,b)->a+b);
            }
            for (char c: a2){
                if (!map.containsKey((int)c)){
                    return false;
                }
                int num =map.get((int)c);
                num -= 1;
                if (num < 0){
                    return false;
                }
                map.put((int) c, num);
            }
            return true;
        }
    }
}
