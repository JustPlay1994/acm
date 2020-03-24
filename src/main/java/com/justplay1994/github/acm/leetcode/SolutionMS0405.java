package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 面试题 04.05. 合法二叉搜索树
 * start 17:16
 * ac 17:29
 */

public class SolutionMS0405 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
        }

        public boolean isValid(TreeNode node, long L, long R){
            if (node == null) return true;
            if (node.val <= L || node.val >= R) return false;
            if (node.left != null){
                if (node.val <= node.left.val){
                    return false;
                }
                if (!isValid(node.left, L, node.val)){
                    return false;
                }
            }
            if (node.right != null){
                if (node.val >= node.right.val){
                    return false;
                }
                if (!isValid(node.right, node.val, R)){
                    return false;
                }
            }
            return true;
        }
    }
}
