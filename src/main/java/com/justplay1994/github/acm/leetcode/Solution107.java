package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/11/27
 * 107. 二叉树的层次遍历 II
 * ac 15:11
 */

public class Solution107 {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int level = 0;
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList();
            }
            List<List<Integer>> result = new ArrayList<>();
            recursive(root, result);
            int i = 0;
            int j = result.size() - 1;
            while (i < j){
                List temp = result.get(i);
                result.set(i, result.get(j));
                result.set(j, temp);
                i++;
                j--;
            }
            return result;
        }

        public void recursive(TreeNode node, List<List<Integer>> list){
            if (list.size() <= level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(node.val);

            level++;
            if (node.left != null){
                recursive(node.left, list);
            }
            if (node.right != null){
                recursive(node.right, list);
            }
            level--;
        }
    }

}
