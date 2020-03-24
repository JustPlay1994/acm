package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/12/9
 * 783. 二叉搜索树结点最小距离
 * start 10:58
 * ac 11:20
 * 二叉搜索树的中序遍历是升序数组
 */

public class Solution783 {



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int minDiffInBST(TreeNode root) {
            int result = Integer.MAX_VALUE;
            //排序
            List<Integer> list = new ArrayList<>();
            toArray(root, list);
            Collections.sort(list);
            //遍历
            for (int i = 1; i < list.size(); i++){
                result = Math.min(result, list.get(i) - list.get(i - 1));
            }
            return result;
        }

        public void toArray(TreeNode node, List list){
            if (node != null){
                list.add(node.val);
                if (node.left != null){
                    toArray(node.left, list);
                }
                if (node.right != null){
                    toArray(node.right, list);
                }
            }
        }
    }

}
