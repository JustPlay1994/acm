package com.justplay1994.github.acm.leetcode;

/**
 * Created by JustPlay1994 on 2019/4/20.
 * https://github.com/JustPlay1994
 * 最大子序和
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/56/
 */

/**
 * c[i] = max{ c[i-1]+c[i], c[i] }
 */
public class Solution53 {


    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        new Solution53().maxSubArray(nums);
    }

    public int maxSubArray(int[] nums ) {
        int[] a = new int[nums.length];
        a[0] = nums[0];
        int result = a[0];
        for (int i = 1; i < nums.length; ++i){
            if (a[i-1] > 0) {
                a[i] = a[i - 1] + nums[i];
            }else {
                a[i] = nums[i];
            }
            if (a[i] > result){
                result = a[i];
            }
        }
        System.out.println(result);
        return result;
    }
}
