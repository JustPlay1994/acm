package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2020/3/29
 * 257. 二叉树的所有路径
 * start 17:13
 * ac 17:35
 */

public class Solution257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        List<String> result = new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return result;
            path(root, "");
            return result;
        }

        public void path(TreeNode node, String str){
            str += "->" + node.val;
            if (node.left == null && node.right == null){
                result.add(str.substring(2));
            }
            if (node.left != null){
                path(node.left, str);
            }
            if (node.right != null){
                path(node.right, str);
            }
        }
    }
}
