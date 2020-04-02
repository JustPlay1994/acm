package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/25
 * 437. 路径总和 III
 * start 10:26
 * ac 14:44
 */

public class Solution437 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int result = 0;
        int sum = 0;
        public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;
            this.sum = sum;
            traversal(root);
            return result;
        }

        public void traversal(TreeNode node){
            dfs(node, sum);
            if (node.left != null){
                traversal(node.left);
            }
            if (node.right != null){
                traversal(node.right);
            }
        }

        public void dfs(TreeNode node, int sum){
            if (node.val == sum){
                result ++;
            }
            if (node.left != null){
                dfs(node.left, sum - node.val);
            }
            if (node.right != null){
                dfs(node.right, sum - node.val);
            }
        }
    }
}
