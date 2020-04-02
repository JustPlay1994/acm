package com.justplay1994.github.acm.leetcode;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangzezhou
 * @date 2020/3/29
 * 559. N叉树的最大深度
 * start 16:30
 * ac 17:11
 */

public class Solution559 {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        public int maxDepth(Node root) {
            if (root == null) return 0;
            LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<>();
            Node node;
            queue.add(root);
            if (root.children != null && root.children.size() > 0){
                queue.addAll(root.children);
            }
            int result = 1;
            while (queue.size() > 1){
                node = queue.poll();
                if (node == root){
                    result++;
                    queue.add(root);
                    continue;
                }
                if (node.children != null && node.children.size() > 0) {
                    queue.addAll(node.children);
                }
            }
            return result;
        }
    }
}
