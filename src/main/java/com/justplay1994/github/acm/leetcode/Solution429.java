package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangzezhou
 * @date 2019/11/23
 * 429. N叉树的层序遍历
 * start 18:13
 * ac 18:29
 * 100 percent
 */

public class Solution429 {


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {

        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(Node root) {
            recursive(root, 0);
            return result;
        }

        public void recursive(Node node, int level){
            if (node == null){
                return;
            }
            if (result.size() < level + 1){
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);
            if (node.children != null){
                for (int i = 0; i < node.children.size(); i++){
                    recursive(node.children.get(i), level + 1);
                }
            }
        }

    }

}
