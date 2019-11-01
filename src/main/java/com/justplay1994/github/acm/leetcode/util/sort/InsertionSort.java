package com.justplay1994.github.acm.leetcode.util.sort;

/**
 * @author huangzezhou
 * @date 2019/10/28
 * 插入排序
 * 时间 O(n^2)
 * 空间 O(1)
 * 稳定性
 */

public class InsertionSort {

    public static void main(String[] args){
        int[] input = new int[]{5,2,4,3,1,9,7,8,6,7,6,7};
        new InsertionSort().sort(input);
        System.out.println();
    }

    /**
     * @param nums
     */
    public void sort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int a = 0;
            boolean replace = false;
            for (int j = 0; j <= i; j++){
                if (replace){
                    int temp = nums[j];
                    nums[j] = a;
                    a = temp;
                    continue;
                }
                if (nums[i] < nums[j]){
                    a = nums[j];
                    nums[j] = nums[i];
                    replace = true;
                }
            }
        }
    }

}
