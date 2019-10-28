package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/10/25
 * 350. 两个数组的交集 II
 * start 14:37
 * end 14:50
 */

public class Solution350 {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> list = new ArrayList<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0;
            int j = 0;
            while (i < nums1.length && j < nums2.length){
                if (nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    i++;
                    j++;
                }else if (nums1[i] > nums2[j]){
                    j++;
                }else{
                    i++;
                }
            }
            int[] result = new int[list.size()];
            for (int k = 0; k < list.size(); k++){
                result[k] = list.get(k);
            }
            return result;
        }
    }

}
