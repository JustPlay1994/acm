package com.justplay1994.github.acm.leetcode;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangzezhou
 * @date 2020/3/29
 * 111. 二叉树的最小深度
 * start 16:09
 * ac 16:29
 */

public class Solution111 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int result = 1;
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            TreeNode node = root;
            queue.add(node);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
            while (queue.size() > 1){
                node = queue.poll();
                if (node == root){
                    queue.add(root);
                    result++;
                }
                if (node.left == null && node.right == null){
                    return result;
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            return result;
        }
    }
}
