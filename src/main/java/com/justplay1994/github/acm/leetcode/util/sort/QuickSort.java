package com.justplay1994.github.acm.leetcode.util.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/10/28
 * 快速排序
 * 时间 O(n * logn)
 * 空间 O(1)
 * 不稳定性：最后一个元素假设有相似，且一开始就被换到开头，就违背了稳定性。
 */

public class QuickSort {

    public static void main(String[] args){
        int[] input = new int[]{5,2,4,3,1,9,7,8,6};
        new QuickSort().sort(input, 0, input.length);
        System.out.println();
    }

    /**
     * 原地快排
     * @param nums
     * @param start
     * @param end
     */
    public void sort(int[] nums, int start, int end){
        if (end - start <= 1){
            return;
        }else if (end - start == 2){
            if (nums[start] > nums[end - 1]){
                int temp = nums[start];
                nums[start] = nums[end - 1];
                nums[end - 1] = temp;
            }
            return;
        }
        int mid = end - 1;
        int i = start;
        int j = end - 1;
        int s = -1;
        while (i <= j){
            if (s == - 1){
                if (nums[i] > nums[mid]){
                    s = 1;
                    int temp = nums[i];
                    nums[i] = nums[mid];
                    nums[mid] = temp;
                    mid = i;
                }
                i++;
            }else {
                if (nums[j] <= nums[mid]) {
                    s = -1;
                    int temp = nums[j];
                    nums[j] = nums[mid];
                    nums[mid] = temp;
                }
                j--;
            }
        }
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
    }
}
