package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/23
 * 74. 搜索二维矩阵
 * start 21:24
 * ac 21:48
 * better 22:10
 * 100%
 */

public class Solution74 {
    public static void main(String[] args){
        int[][] test = new int[1][0];
        System.out.println(test.length);
        if (test == null || test.length == 0 || test[0].length == 0){
            System.out.println(1);
        }
        System.out.println(test[0][0]);
    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return false;
            }
            if (target < matrix[0][0]){
                return false;
            }
            for (int i = 0; i < matrix.length; i++){
                if (target == matrix[i][0]){
                    return true;
                }
                if (target < matrix[i][0]){
                    if (searchSplit2(matrix[i - 1], target)){
                        return true;
                    }
                }
                if (i == matrix.length - 1){
                    if (searchSplit2(matrix[i], target)){
                        return true;
                    }
                }
            }
            return false;
        }
        public boolean searchSplit2(int[] arr, int target){
            int min = 0;
            int max = arr.length - 1;
            if (arr[max] == target || arr[min] == target){
                return true;
            }
            int index = max / 2;
            while (index != min){
                if (arr[index] == target){
                    return true;
                }else if (arr[index] > target){
                    max = index;
                    index = max / 2;
                }else{
                    min = index;
                    index = min + (max - min) / 2;
                }
            }
            return false;
        }
    }


}
