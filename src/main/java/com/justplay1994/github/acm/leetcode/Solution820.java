package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/28
 * 820. 单词的压缩编码
 * start 9:28
 * ac 10:22
 */

public class Solution820 {
    class Solution {
        class Node{
            Node[] next = new Node[26];
        }
        //后缀树
        //还要算#号，需要计算叶子节点数量
        int result = 0;
        Node root = new Node();
        public int minimumLengthEncoding(String[] words) {


            for (String word : words) {
                Node node = root;
                char[] arr = word.toCharArray();
                for (int j = arr.length - 1; j >= 0; j--) {
                    Node temp = node.next[arr[j] - 'a'];
                    //节点是否已存在
                    if (temp == null) {
                        temp = new Node();
                        node.next[arr[j] - 'a'] = temp;
                    }
                    node = temp;
                }
            }
            recursive(root, 0);
            return result;
        }

        private void recursive(Node node, int count){
            boolean allNull = true;
            for (Node node1 : node.next){
                if (node1 != null){
                    recursive(node1, count + 1);
                    allNull = false;
                }
            }
            if (allNull){
                if (node != root){
                    result += count + 1;
                }
            }
        }
    }
}
