package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/8/21
 * 969-煎饼排序
 */

public class Solution969AC {

    public static void main(String[] args){
        int[] intput = {1};
        Object result = new Solution969AC().pancakeSort(intput);
        System.out.println();
    }

    public List<Integer> pancakeSort(int[] input) {
        List<Integer> result = new ArrayList<Integer>(input.length + 1);
        int length = input.length;
        while(true){
            int maxNumIndex = maxNumIndex(input, length);
            if (maxNumIndex != length - 1){
                result.add(maxNumIndex + 1);
                //将当前最大值交换至第一位
                revers(input, maxNumIndex+1);
                //在将第一位交换至最后一位
                revers(input, length);
                result.add(length);
            }
            length --;
            if (length <= 1) {
                break;
            }
        }
        return result;
    }

    /**
     * 当前最大值下标
     */
    public int maxNumIndex(int[] input, int length){
        int result = input[0];
        int resultIndex = 0;
        for (int i = 1; i < length; i++){
            if (input[i] > result){
                result = input[i];
                resultIndex = i;
            }
        }
        return resultIndex;
    }

    /**
     * 计算k值，k翻转能把当前值翻转到数组最后一位。
     * 要么零步、要么两步
     * @param index 当前数下标
     * @param length 数组长度
     * @return
     */
//    public int[] calculateK(int index, int length){
//        int[] result = {index + 1, length};
//        return result;
//
//    }

    /**
     * k翻转操作
     * @param input
     * @param k
     * @return
     * 0 ... k-1
     */
    public void revers(int[] input, int k){
        int begin = 0;
        int end = k - 1;
        while (begin < end) {
            int temp = input[begin];
            input[begin] = input[end];
            input[end] = temp;
            begin++;
            end--;
        }
    }
}
