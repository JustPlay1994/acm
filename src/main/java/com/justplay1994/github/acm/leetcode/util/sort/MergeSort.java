package com.justplay1994.github.acm.leetcode.util.sort;

/**
 * @author huangzezhou
 * @date 2019/10/28
 * 归并排序
 * 时间 O(nlogn)
 * 空间 O(nlogn)
 * 稳定性
 */

public class MergeSort {

    public static void main(String[] args){
        int[] input = new int[]{5,2,4,3,1,9,7,8,6,7,6,7};
        int[] result = new MergeSort().sort(input);
        System.out.println(result);
    }

    /**
     *
     * @param nums
     */
    public int[] sort(int[] nums) {
        if (nums.length == 1){
            return nums;
        }

        int mid = (nums.length - 1) / 2;

        int[] left = new int[mid + 1];
        int[] right = new int[nums.length - mid - 1];
        for (int i = 0; i < nums.length; i++){
            if (i <= mid){
                left[i] = nums[i];
            }else {
                right[i - mid - 1] = nums[i];
            }

        }
        int[] leftResult = sort(left);
        int[] rightResult = sort(right);

        int[] result = new int[leftResult.length + rightResult.length];
        int i = 0, j = 0;
        while (i < leftResult.length || j < rightResult.length){
            while ( i < leftResult.length){
                if (j >= rightResult.length){
                    result[i + j] = leftResult[i];
                }else if (leftResult[i] <= rightResult[j]){
                    result[i + j] = leftResult[i];
                }else {
                    break;
                }
                i++;
            }
            while ( j < rightResult.length ){
                if (i >= leftResult.length){
                    result[i + j] = rightResult[j];
                }else if (leftResult[i] > rightResult[j]){
                    result[i + j] = rightResult[j];
                }else {
                    break;
                }
                j++;
            }
        }
        return result;
    }
}
