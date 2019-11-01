package com.justplay1994.github.acm.leetcode.util.sort;

import java.util.Comparator;

/**
 * @author huangzezhou
 * @date 2019/10/28
 * 冒泡排序
 * 时间 O(n^2)
 * 空间 O(1)
 * 稳定性
 */

public class BubbleSort {

    public static void main(String[] args){
        int[] intput = new int[]{5,2,4,3,1};
        new BubbleSort().sort(intput);
        System.out.println();
    }

    public void sort(int[] nums){
        for (int i = nums.length - 1; i >= 0; i--){
            for (int j = 0; j < i; j++){
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
