package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/5
 * 123. 买卖股票的最佳时机 III
 */
public class Solution123 {


    public static void main(String[] args){
        int result = new Solution().maxProfit(new int[]{});
        System.out.println(result);
    }


    static class Solution {
        public int maxProfit(int[] prices) {
            int result = 0;
            for (int i = 0; i < prices.length; i++){
                int temp = partition(prices, i);
                result = result > temp ? result : temp;
            }
            return result;
        }

        /**
         * 计算该划分下，两次机会最大赚钱数
         * 划分为两个区域，分别求最大赚钱数。左区域必定存在，右区域可以不存在
         * @param prices
         * @param k
         * @return
         */
        public int partition(int[] prices, int k){
            //左区划最大值
            int leftMax = 0;
            //每个区至少包含一个值
            for(int i = 0; i < k; i++){
                int temp = partition(prices, 0, k + 1, i);
                leftMax = leftMax > temp ? leftMax : temp;
            }
            //右区划最大值
            int rightMax = 0;
            //每个区至少包含一个值
            for(int i = k + 1; i < prices.length - 1; i++){
                int temp = partition(prices, k + 1, prices.length, i);
                rightMax = rightMax > temp ? rightMax : temp;
            }
            return leftMax + rightMax;
        }

        /**
         * 计算该区域的最大赚钱数
         * 划分为左右两个区域，左边求最小值，右边求最大值，每个区域至少包含一个数
         * @param prices
         * @return
         */
        public int partition(int[] prices, int start, int end, int k){
            if (start == end) return 0;
            int leftMin = 0x7fffffff;
            int rightMax = 0x80000000;
            for (int i = start; i < end; i++){
                if (i <= k){
                    leftMin = leftMin < prices[i] ? leftMin : prices[i];
                }else {
                    rightMax = rightMax > prices[i] ? rightMax : prices[i];
                }
            }
            return 0 > rightMax - leftMin ? 0 : rightMax - leftMin;
        }
    }
}
