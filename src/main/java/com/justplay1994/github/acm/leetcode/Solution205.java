package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2019/10/30
 * 205. 同构字符串
 * start 15:42
 * end 15:55
 */

public class Solution205 {

    public static void main(String[] args){
        boolean reult = new Solution().isIsomorphic("ass","bxx");
        System.out.println(reult);
    }
    static
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) return false;
            StringBuilder str = new StringBuilder();
            HashMap map = new HashMap();
            StringBuilder tr = new StringBuilder();
            HashMap map1 = new HashMap();
            int j = 0;
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (map.get(c) == null){
                    map.put(c,j);
                    j++;
                }
                str.append(map.get(c));
            }
            j = 0;
            for (int i = 0; i < t.length(); i++){
                char c = t.charAt(i);
                if (map1.get(c) == null){
                    map1.put(c, j);
                    j++;
                }
                tr.append(map1.get(c));
            }
            return str.toString().equals(tr.toString());
        }
    }
}
