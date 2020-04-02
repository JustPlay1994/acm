package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/25
 * 112. 路径总和
 * start 10:21
 * ac 10:25
 */

public class Solution112 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            if (root.val == sum && root.left == null && root.right == null) return true;
            boolean left = false;
            boolean right = false;
            if (root.left != null){
                left = hasPathSum(root.left, sum - root.val);
            }
            if (root.right != null){
                right = hasPathSum(root.right, sum - root.val);
            }
            return left || right;
        }
    }

}
