package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huangzezhou
 * @date 2019/10/30
 * 349. 两个数组的交集
 * start 16:27
 * end 16:33
 * one time
 */

public class Solution349 {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashMap map = new HashMap();
            for (int i = 0; i < nums1.length; i++){
                map.put(nums1[i], 1);
            }
            Set<Integer> set = new HashSet();
            for (int j = 0; j < nums2.length; j++){
                if (map.get(nums2[j]) != null){
                    set.add(nums2[j]);
                }
            }
            int[] result = new int[set.size()];
            int i = 0;
            for (Integer value: set){
                result[i] = value;
                i++;
            }
            return result;
        }
    }

}
