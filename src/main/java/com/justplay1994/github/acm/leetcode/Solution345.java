package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2020/3/23
 * 345. 反转字符串中的元音字母
 * start 15:42
 * ac 16:02
 */

public class Solution345 {

    public static void main(String []args){
        new Solution().reverseVowels("hello");
    }

    static
    class Solution {
        public String reverseVowels(String s) {
            // a e i o u
            char[] arr = s.toCharArray();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++){
                if (isVowel(arr[i])){
                    list.add(i);
                }
            }
            for (int i = 0; i < list.size() / 2; i++){
                char temp = arr[list.get(i)];
                arr[list.get(i)] = arr[list.get(list.size() - i - 1)];
                arr[list.get(list.size() - i -1)] = temp;
            }
            return new String(arr);
        }
        boolean isVowel(char c){
            return c == 'a'
                    || c == 'e'
                    || c == 'i'
                    || c == 'o'
                    || c == 'u'
                    || c == 'A'
                    || c == 'E'
                    || c == 'I'
                    || c == 'O'
                    || c == 'U';
        }
    }

}
