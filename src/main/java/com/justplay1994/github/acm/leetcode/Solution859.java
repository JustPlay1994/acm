package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2019/10/31
 * 859. 亲密字符串
 * start 11:50
 */

public class Solution859 {

    public static void main(String[] args){
        new Solution().buddyStrings("ab", "ba");
    }
    static
    class Solution {
        public boolean buddyStrings(String A, String B) {
            char t1 = 0;
            char t2 = 0;
            int x = 0;
            if (A.length() < 2 || B.length() < 2 || A.length() != B.length()){
                return false;
            }
            for (int i = 0; i < A.length(); i++){
                if (A.charAt(i) != B.charAt(i)){
                    x++;
                    if (x > 2){
                        return false;
                    }
                    if (t1 == 0){
                        t1 = A.charAt(i);
                        t2 = B.charAt(i);
                    }else {
                        if (A.charAt(i) != t2 || B.charAt(i) != t1){
                            return false;
                        }
                    }
                }
            }
            if (x == 0){
                HashMap map = new HashMap();
                for (int i = 0; i < A.length(); i++){
                    if (map.get(A.charAt(i)) == null){
                        map.put(A.charAt(i), 1);
                    }else {
                        return true;
                    }
                }
            }
            return x == 2;
        }
    }

}
