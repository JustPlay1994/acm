package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/29
 * 110. 平衡二叉树
 * start 15:56
 * ac 16:06
 */

public class Solution110 {



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        boolean result = true;
        public boolean isBalanced(TreeNode root) {
            depth(root);
            return result;
        }

        private int depth(TreeNode node){
            if (!result) return 0;
            if (node == null) return 0;
            int left = depth(node.left);
            int right = depth(node.right);
            if (Math.abs(left - right) > 1){
                result = false;
            }
            return Math.max(left,right) + 1;
        }
    }
}
