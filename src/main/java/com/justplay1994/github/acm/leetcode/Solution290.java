package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2019/10/30
 * 290. 单词规律
 * start 15:59
 */

public class Solution290 {

    public static void main(String[] args){
        System.out.println(new Solution().wordPattern("abb","as bc bc"));
    }
    static
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if (words.length != pattern.length())return false;
            HashMap map = new HashMap();
            StringBuilder result = new StringBuilder();
            int j = 0;
            for (int i = 0; i < pattern.length(); i++){
                char c = pattern.charAt(i);
                if (map.get(c) == null){
                    map.put(c, j);
                    j++;
                }
                result.append(map.get(c));
            }
            HashMap map1 = new HashMap();
            j = 0;

            StringBuilder result1= new StringBuilder();
            for (String word: words){
                int c = word.hashCode();
                if (map1.get(c) == null){
                    map1.put(c, j);
                    j++;
                }
                result1.append(map1.get(c));
            }
            return result.toString().equals(result1.toString());
        }
    }
}
