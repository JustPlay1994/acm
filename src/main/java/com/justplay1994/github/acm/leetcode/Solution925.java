package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/11
 * 925. 长按键入
 * start 10:47
 */

public class Solution925 {
    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int i = 0;
            int j = 0;
            while (i < name.length() && j < typed.length() ){
                if (name.charAt(i) == typed.charAt(j)){
                    i++;j++;
                }else {
                    if (i > 0 && name.charAt( i - 1) == typed.charAt(j)){
                        j++;
                    }else {
                        return false;
                    }
                }
            }
            if (i != name.length()){
                return false;
            }
            return true;
        }
    }
}
