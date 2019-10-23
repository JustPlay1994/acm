package com.justplay1994.github.acm.leetcode;

import java.util.*;

/**
 * @author huangzezhou
 * @date 2019/10/6
 * 5214. 最长定差子序列
 */


/*
输入：
[1,5,7,8,5,3,4,2,1]
-2
输出：
2
预期：
4

 */

/*

输入：
[3,0,-3,4,-4,7,6]
3
输出：
4
预期：
2
 */



public class Solution5214 {


    public static void main(String[] args){
        new Solution().longestSubsequence(new int[]{3,0,-3,4,-4,7,6}, 3);
    }

    static class Solution {
        class Node{
            int val;
            int num;

            Node(int val, int num){
                this.val = val;
                this.num = num;
            }
        }

        public int longestSubsequence(int[] arr, int difference) {
            if (difference == 0){
                return deal0(arr);
            }else {
                int result = 1;
                List<Integer> max = new ArrayList<>();
                for (int i = 0; i < arr.length; i++){
                    if (! (arr.length  - i <= result)){
                        max.add(1);
                    }
                    for (int j = 0; j < i && j< max.size(); j++){
                        if (arr[i] - arr[j] == difference * max.get(j)){
                            max.set(j, max.get(j) + 1);
                            result = result > max.get(j) ? result : max.get(j);
                        }

                    }
                }
                return result;
            }
        }

        public int deal0(int[] arr){
            int result = 1;
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++){
                boolean isFound = false;
                for (Node node: list){
                    if (node.val == arr[i]){
                        node.num++;
                        isFound = true;
                        result = result > node.num ? result : node.num;
                    }

                }
                if (!isFound){
                    list.add(new Node(arr[i], 1));
                }
            }
            return result;
        }

    }
}
