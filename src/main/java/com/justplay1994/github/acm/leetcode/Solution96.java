package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/10
 * 96. 不同的二叉搜索树
 * start 12:10
 */

public class Solution96 {

    class Solution {
        public int numTrees(int n) {
            return count(1, n);
        }

        int count(int start, int endInclude){
            if (start == endInclude) return 1;
            int result = 0;
            for (int i = start; i <= endInclude; i++){
                int left = 1;
                int right = 1;
                //选取i作为根节点
                //左子树
                if (start != i){
                    left = count(start, i - 1);
                }
                //右子树
                if (endInclude != i){
                    right = count(i + 1, endInclude);
                }
                result += left * right;
            }
            return result;
        }
    }

}
