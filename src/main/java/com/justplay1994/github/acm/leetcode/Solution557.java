package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 557. 反转字符串中的单词 III
 * start 16:10
 * ac 16:20
 */

public class Solution557 {
    class Solution {
        public String reverseWords(String s) {
            StringBuilder builder = new StringBuilder();
            char[] a = s.toCharArray();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < a.length; i++){
                if (a[i] != ' '){
                    list.add((int) a[i]);
                }else {
                    while (list.size() > 0){
                        char c = (char)list.get(list.size() - 1).intValue();
                        builder.append(c);
                        list.remove(list.size() - 1);
                    }
                    builder.append(' ');
                }
            }
            while (list.size() > 0){
                char c = (char)list.get(list.size() - 1).intValue();
                builder.append(c);
                list.remove(list.size() - 1);
            }
            return builder.toString();
        }
    }
}
