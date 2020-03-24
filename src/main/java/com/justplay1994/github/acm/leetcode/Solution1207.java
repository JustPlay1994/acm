package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 1207. 独一无二的出现次数
 * start 10:53
 * ac 11:00
 */

public class Solution1207 {
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap();
            for (int i1 : arr) {
                if (map.get(i1) != null) {
                    map.put(i1, map.get(i1) + 1);
                }else {
                    map.put(i1, 1);
                }
            }
            HashMap map1 = new HashMap();
            for (Map.Entry entry: map.entrySet()){
                if (map1.get(entry.getValue()) != null){
                    return false;
                }
                map1.put(entry.getValue(), 1);
            }
            return true;
        }
    }
}
