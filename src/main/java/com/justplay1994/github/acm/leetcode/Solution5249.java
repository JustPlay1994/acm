package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/11/3
 * 5249. 移除无效的括号
 * one time
 */

public class Solution5249 {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            List<Integer> left = new ArrayList<>();
            List<Integer> needDelete = new ArrayList<>();
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == '('){
                    left.add(i);
                }else if (s.charAt(i) == ')'){
                    if (left.size() > 0) {
                        left.remove(left.size() - 1);
                    }else {
                        needDelete.add(i);
                    }
                }
            }
            needDelete.addAll(left);
            HashMap map = new HashMap();
            for (Integer i: needDelete){
                map.put(i, 1);
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                if (map.get(i) != null){
                    continue;
                }
                builder.append(s.charAt(i));
            }
            return builder.toString();
        }
    }
}
