package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/23
 * 9. 回文数
 * start 19:27
 * ac 19:51
 *
 */

public class Solution9 {

    public static void main(String[] args){
        System.out.println(new Solution().isPalindrome(10));
        System.out.println(1 >>> 1);
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            StringBuilder builder = new StringBuilder();
            char c;
            while (x > 0){
                c = (char) (x % 10);
                x = x / 10;
                builder.append(c);
            }
            String str = builder.toString();
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) != str.charAt(str.length() - 1 -i)){
                    return false;
                }
            }
            return true;
        }
    }
}
