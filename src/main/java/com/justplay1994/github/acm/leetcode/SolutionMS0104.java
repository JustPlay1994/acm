package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 面试题 01.04. 回文排列
 * start 11:03
 * ac 11:24
 */

public class SolutionMS0104 {
    class Solution {
        public boolean canPermutePalindrome(String s) {
            HashMap<Object, Integer> map = new HashMap<>();
            char[] a = s.toCharArray();
            for (int i = 0; i < a.length; i++){
                if (map.get(a[i]) == null){
                    map.put(a[i], 1);
                }else {
                    map.put(a[i], map.get(a[i]) + 1);
                }
            }
            int odd = 0;
            for (Map.Entry<Object,Integer> entry: map.entrySet()){
                if (entry.getValue() % 2 == 1){
                    odd++;
                    if (odd > 1){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
