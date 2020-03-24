package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/11/3
 * 5248. 统计「优美子数组」
 * one time
 */

public class Solution5248 {

    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            List<Integer> oddIndex = new ArrayList<>();
            for (int i = 0; i < nums.length; i++){
                if (nums[i] % 2 != 0){
                    oddIndex.add(i);
                }
            }
            if (oddIndex.size() < k) return 0;
            List<Integer> current = new ArrayList<>();
            int result = 0;
            for (int i = 0; i < oddIndex.size(); i++){
                current.add(i);
                if (current.size() < k){
                    continue;
                }
                if (current.size() > k){
                    current.remove(0);
                }
                int start = current.get(0);
                int end = current.get(current.size() - 1);
                int left = 0;
                int right = 0;
                if (start == 0){
                    left = oddIndex.get(start) - 0 + 1;
                }else {
                    left = oddIndex.get(start) - oddIndex.get(start - 1);
                }
                if (end == oddIndex.size() - 1){
                    right = nums.length - 1 - oddIndex.get(end) + 1;
                }else {
                    right = oddIndex.get(end + 1) - oddIndex.get(end);
                }
                result += left * right;
            }
            return result;
        }

    }

}
