package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/11/9
 * 94. 二叉树的中序遍历
 * start 11:11
 * ac 11:22
 */

public class Solution94 {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null){
                return new ArrayList<>();
            }
            List<Integer> left = inorderTraversal(root.left);
            List<Integer> right = inorderTraversal(root.right);
            List<Integer> result = new ArrayList<>();

            result.addAll(left);
            result.add(root.val);
            result.addAll(right);
            return result;
        }

    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
