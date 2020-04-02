package com.justplay1994.github.acm.leetcode;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangzezhou
 * @date 2020/3/29
 * 101. 对称二叉树
 * start 17:43
 * ac 18:23
 */

public class Solution101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return recursive(root, root);
        }

        private boolean recursive(TreeNode node, TreeNode node2){
            if (node == node2 && node == null)return true;
            if(node == null || node2 == null){
                return false;
            }
            if (node.val != node2.val)return false;

            boolean result = true;
            result = recursive(node.left, node2.right);
            if (!result) return false;
            result = recursive(node.right, node2.left);
            return result;
        }
    }
}
