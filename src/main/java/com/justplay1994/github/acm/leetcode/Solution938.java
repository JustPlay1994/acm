package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 938. 二叉搜索树的范围和
 * start 11:52
 * ac 15:14
 */

public class Solution938 {



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        int result;
        TreeNode first;//最下公共父节点

        public int rangeSumBST(TreeNode root, int L, int R) {
            return count(searchRoot(root, L, R), L, R);
        }
        public TreeNode searchRoot(TreeNode node, int L, int R){
            if (node.val >= L && node.val <= R) return node;
            if (node.val < L){
                return searchRoot(node.right, L, R);
            }
            return searchRoot(node.left, L, R);
        }

        public int count(TreeNode node, int L, int R){
            int result = 0;
            if (node.val >= L && node.val <= R) {
                result += node.val;
                if (node.left != null){
                    result += count(node.left, L, R);
                }
                if (node.right != null){
                    result += count(node.right, L, R);
                }
            }else if (node.val > R){
                if (node.left != null) {
                    result += count(node.left, L, R);
                }
            }else if (node.right != null && node.val < L){
                    result += count(node.right, L, R);
            }
            return result;
        }
    }
}
