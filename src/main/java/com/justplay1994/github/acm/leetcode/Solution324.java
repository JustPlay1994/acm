package com.justplay1994.github.acm.leetcode;

import java.util.*;

/**
 * @author huangzezhou
 * @date 2019/10/27
 * 324. 摆动排序 II
 * start 14:30
 *
 */

public class Solution324 {

    public static void main(String[] args){
//        new Solution().wiggleSort(new int[]{1,3,2,2,3,1});
        new Solution().wiggleSort(new int[] {4,5,5,6});
    }
static
    class Solution {
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            int[] sort = nums.clone();
            int max;
            if (nums.length % 2 == 0){
                max = nums.length / 2 - 1;
            }else {
                max = nums.length /2;
            }
            for (int i = 1, j = nums.length - 1; i < nums.length ; i += 2, j --){
                nums[i] = sort[j];
            }
            for (int i = 0, j = max; j >= 0; i += 2, j--){
                nums[i] = sort[j];
            }
        }
    }

}
