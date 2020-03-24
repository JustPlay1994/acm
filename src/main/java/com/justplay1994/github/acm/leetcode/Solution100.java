package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/11/23
 * 100. 相同的树
 * start 11:09
 * ac 11:19
 * 100 percent
 */

public class Solution100 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null){
                return true;
            }
            if (p == null || q == null){
                return false;
            }
            if (p.val != q.val){
                return false;
            }
            if (!isSameTree(p.left, q.left)){
                return false;
            }
            if (!isSameTree(p.right, q.right)){
                return false;
            }
            return true;
        }
    }

}
