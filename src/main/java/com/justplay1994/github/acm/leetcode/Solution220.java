package com.justplay1994.github.acm.leetcode;

import java.math.BigInteger;

/**
 * @author huangzezhou
 * @date 2019/10/30
 * 220. 存在重复元素 III
 * start 16:35
 */

public class Solution220 {

    public static void main(String[] args){
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 3, 3));

        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
    }
    static
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (nums == null || nums.length == 0) return false;
            for (int i = 0; i < k; i++){
                for (int j = i + 1; j <= (k < nums.length ? k : nums.length - 1); j++){
                    if (BigInteger.valueOf(t).compareTo(BigInteger.valueOf(nums[i]).subtract(BigInteger.valueOf(nums[j])).abs()) >= 0){
                        return true;
                    }
                }
            }
            if (k >= nums.length) return false;
            for (int i = k + 1; i < nums.length; i++){
                for (int j = i - k; j < i; j++ ){
                    if (BigInteger.valueOf(t).compareTo(BigInteger.valueOf(nums[i]).subtract(BigInteger.valueOf(nums[j])).abs()) >= 0){
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
