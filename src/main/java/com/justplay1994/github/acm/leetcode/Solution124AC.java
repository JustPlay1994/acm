package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/9/17
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * 重点在于，每个节点有三个方向，只有四种选择：
 * 1. 选择停在这里
 * 2. 向上
 * 3. 向右
 * 4. 向左
 * <p>
 * 注意边界：至少包含一个节点
 */

public class Solution124AC {

    //    static Integer[] input = {-10,9,20,null,null,15,7};     //42
    static Integer[] input = {1};     //42

    static List<TreeNode> treeNodes = new ArrayList<>(input.length);

    public static void main(String[] args) {
        for (int i = 0; i < input.length; i++) {
            treeNodes.add(null);
        }


        TreeNode root = null;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == null) continue;
            TreeNode treeNode;
            if (i == 0) {
                treeNode = new TreeNode(input[i]);
                root = treeNode;
                treeNodes.set(i, treeNode);
            } else {
                treeNode = treeNodes.get(i);
            }
            if (2 * i + 1 > 0 && 2 * i + 1 < input.length) {
                Integer left = input[2 * i + 1];
                if (left != null) {
                    treeNode.left = new TreeNode(left);
                    treeNodes.set(2 * i + 1, treeNode.left);
                }
            }
            if (2 * i + 2 > 0 && 2 * i + 2 < input.length) {
                Integer right = input[2 * i + 2];
                if (right != null) {
                    treeNode.right = new TreeNode(right);
                    treeNodes.set(2 * i + 2, treeNode.right);
                }
            }
        }
        System.out.println(new Solution().maxPathSum(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {

        class Max {
            int left;
            int right;
            int top;

            int getMaxLeftRight() {
                return left > right ? left : right;
            }

        }

        class Node {
            int val;
            Node left = null;
            Node right = null;
            Node parent = null;
            Max max = new Max();

            Node(int val) {
                this.val = val;
            }

        }

        Node myRoot;

        int result = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            myRoot = new Node(root.val);
            recursionTreeNode(root, myRoot);
            computeMax(myRoot.max.getMaxLeftRight());
            myRoot.max.top = myRoot.val;
            if (myRoot.left != null)
                recursionNode(myRoot.left);
            if (myRoot.right != null)
                recursionNode(myRoot.right);
            return result;
        }

        void computeMax(int max) {
            result = result > max ? result : max;
        }

        /**
         * 计算所有节点的max.top
         *
         * @param node
         */
        void recursionNode(Node node) {
            //判断本节点是左孩子
            node.max.top = node.val;
            if (node.parent.left == node) {
                if (node.parent.max.right > node.parent.max.top && node.parent.max.right > 0) {
                    node.max.top += node.parent.max.right;
                } else if (node.parent.max.top > 0) {
                    node.max.top += node.parent.max.top;
                }
            } else if (node.parent.right == node) {
                if (node.parent.max.left > node.parent.max.top && node.parent.max.left > 0) {
                    node.max.top += node.parent.max.left;
                } else if (node.parent.max.top > 0) {
                    node.max.top += node.parent.max.top;
                }
            }
            //上面逻辑一定会执行一条
            computeMax(node.max.top);

            if (node.left != null)
                recursionNode(node.left);
            if (node.right != null)
                recursionNode(node.right);
        }

        /**
         * 初始化树结构，数据节点以及辅助节点Max.left，Max.right
         *
         * @param treeNode
         * @param node
         */
        void recursionTreeNode(TreeNode treeNode, Node node) {
            node.max.left = node.val;
            node.max.right = node.val;
            if (treeNode.left != null) {
                node.left = new Node(treeNode.left.val);
                node.left.parent = node;
                recursionTreeNode(treeNode.left, node.left);
                node.max.left = node.val;
                if (node.left.max.getMaxLeftRight() > 0) {
                    node.max.left += node.left.max.getMaxLeftRight();
                }
            }
            computeMax(node.max.left);
            if (treeNode.right != null) {
                node.right = new Node(treeNode.right.val);
                node.right.parent = node;
                recursionTreeNode(treeNode.right, node.right);
                if (node.right.max.getMaxLeftRight() > 0) {
                    node.max.right += node.right.max.getMaxLeftRight();
                }
            }
            computeMax(node.max.right);
        }
    }
}


