package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/5
 */

/**
 * 239.滑动窗口最大值
 */
class Solution239AC {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max=0;
        int[] result = new int[nums.length - k +1];
        if(nums.length==0) return new int[0];
        for(int i = 0; i < nums.length; i++){
            if(i<k){
                max = nums[max] > nums[i] ? max : i;
            }else {
                result[i-k] = nums[max];
                int out = i - k;
                if(max!=out){
                    max = nums[max] > nums[i] ?  max : i;
                }else{
                    max = out + 1;
                    for(int j = out +1; j <= i; j++){
                        max = nums[max] > nums[j] ? max : j;
                    }
                }
            }



        }
        result[nums.length-k]=nums[max];
        return result;
    }
}
