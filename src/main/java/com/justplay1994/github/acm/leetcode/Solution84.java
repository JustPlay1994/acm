package com.justplay1994.github.acm.leetcode;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 84. 柱状图中最大的矩形
 *
 * 方法一（失败）：想用53最大子序和的贪心。 问题在于a[j] = max{a[j-1], a[j]}这个式子不成立，例如{1,2,2},导致a[j]在进入j-1后发生了变化。53的核心在于，a[j]跑到j+1中，起点i还是不变。
 * 方法二（失败）：等高线，超时。O（N^3）
 * 方法三（失败）：优化方法二，不用等高线去遍历，而是选择一根柱子去刷面积。
 * 方法四（击败5%）：基于方法三，如果该高度已使用过，则跳过。
 * 方法五：将柱子存入hashmap中，并排序。从低到高进行等高线筛选，当更高一层的等高线不能超过第一层的等高线时，退出。
 * =============  领悟了题的类型，分割线 ==================
 * 方法六：稀疏矩阵遍历，每一行的最大连续串，权重从上往下为n~1。 稀疏矩阵走不通，因为是为了节约横向遍历的长度，但是纵向并没有解决，遇到27亿高的时候就不行了。
 */
class Solution84 {

    public int largestRectangleArea(int[] heights) {
        int result = 0;

        return result;
    }


    public static void main(String[] args){
        int[] test = new int[30000];
        for (int i = 0; i < 30000; ++i){
            test[i]=1;
        }
        int[] heights = {2147483647};
        int[] test1 = {2,1,5,6,2,3};
        int[] test2 = {2,2,3};
        int[] test3 = {3,3};
        System.out.println(new Solution84().largestRectangleArea(heights));
    }
}

/**
 * 84. 柱状图中最大的矩形
 *
 * 方法一（失败）：想用53最大子序和的贪心。 问题在于a[j] = max{a[j-1], a[j]}这个式子不成立，例如{1,2,2},导致a[j]在进入j-1后发生了变化。53的核心在于，a[j]跑到j+1中，起点i还是不变。
 */
class Solution84_error1 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) {
            return 0;
        }
        
        int result = 0;
        int area=0;
        int minHeight=0;
        
        area = heights[0];
        minHeight = heights[0];
        
        result = area;
        
        for(int i = 1; i < heights.length; i++){
            if(heights[i] == 0) {
                area = 0;
                minHeight = 0;
                continue;
            }else if (area == 0){
                area = heights[i];
                minHeight = heights[i];
            }else {
                int width = area / minHeight + 1;
                minHeight = minHeight < heights[i] ? minHeight : heights[i];
                area = width * minHeight;
                if (area < heights[i]) {
                    area = heights[i];
                    minHeight = heights[i];
                }
            }
            if(result < area){
                result = area;
            }

        }
        return result;    
    }

    public static void main(String[] args){
        int[] heights = {1,2,2};
        System.out.println(new Solution84_error1().largestRectangleArea(heights));
    }
}