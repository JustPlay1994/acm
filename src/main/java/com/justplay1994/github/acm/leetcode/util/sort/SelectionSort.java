package com.justplay1994.github.acm.leetcode.util.sort;

/**
 * @author huangzezhou
 * @date 2019/10/28
 * 选择排序
 * 时间 O(n^2)
 * 空间 O(1)
 * 稳定性
 */

public class SelectionSort {

    public static void main(String[] args){
        int[] intput = new int[]{5,2,4,3,1};
        new SelectionSort().sort(intput);
        System.out.println();
    }

    public void sort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

}
