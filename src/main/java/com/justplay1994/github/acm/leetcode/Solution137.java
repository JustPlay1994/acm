package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/12/9
 * 137. 只出现一次的数字 II
 * start 14:49
 * ac
 */

public class Solution137 {

    class Solution {
        public int singleNumber(int[] nums) {
            int[] bit_0 = new int[32];
            for (int i = 0; i < nums.length; i++){
                int temp = nums[i];
                for (int j = 0; j < 32; j++){
                    if (temp % 2 == 0){
                        bit_0[j]++;
                    }
                    temp = temp >> 1;
                }
            }
            int result = 0;
            for (int i = 31; i >=0; i--){
                if (bit_0[i] % 3 != 0){
                    result = result << 1;
                }else {
                    result = result << 1;
                    result ++;
                }
            }
            return result;
        }
    }

    //最优
    public int test(int[] nums){
        int a = 0, b = 0;
        for (int x : nums){
            b = (b ^ x) & ~a;
            a = (a ^ x) & ~b;
        }
        return b;
    }
}
