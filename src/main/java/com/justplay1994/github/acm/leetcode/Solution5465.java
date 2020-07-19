package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author justplay1994
 * @date 2020-7-19 11:11
 */
public class Solution5465 {

    public static void main(String[] args){
        new Solution5465().new Solution().countSubTrees(7, new int[][]{{0,1}, {0,2}, {1,4}, {1,5}, {2,3}, {2,6}}, "abaedcd");
    }

    class Solution {

        class Node{
            int index;
            int[] values = new int[26];
            Node parent;
            List<Node> children = new ArrayList<Node>();

            Node(int index, int value, Node parent){
                this.index = index;
                this.values[value] = 1;
                this.parent = parent;
            }

            public int computeValue(int input){
                return values[input];
            }
        }


        public int[] countSubTrees(int n, int[][] edges, String labels) {
            char[] label = labels.toCharArray();
            Node[] allNodes = new Node[n];

            List<Integer>[] array = new List[n];

            for (int[] edge : edges) {
                if (array[edge[0]] == null) {
                    array[edge[0]] = new ArrayList<>();
                }
                array[edge[0]].add(edge[1]);
                if (array[edge[1]] == null) {
                    array[edge[1]] = new ArrayList<>();
                }
                array[edge[1]].add(edge[0]);
            }

            Queue<Node> queue = new LinkedList<>();
            Node root = new Node(0, label[0] - 'a', null);
            queue.offer(root);
            allNodes[0] = root;
            while (queue.size() > 0){
                Node node_i = queue.poll();
                for (Integer j: array[node_i.index]){
                    if (array[j] != null){
                        Node temp = new Node(j, label[j] - 'a', node_i);
                        node_i.children.add(temp);
                        queue.add(temp);
                        allNodes[j] = temp;
                    }
                }
                array[node_i.index] = null;
            }

            recursive(allNodes[0]);

            int[] result = new int[n];
            for(int i = 0; i < allNodes.length; i++){
                Node node = allNodes[i];
                result[i] = node.computeValue(label[node.index] - 'a');
            }
            return result;
        }

        private void recursive(Node node){
            for (Node child: node.children) {
                recursive(child);
                add(node.values, child.values);
            }
        }

        private void add(int[] parent, int[] child){
            for(int i = 0; i < parent.length; i++){
                parent[i] = parent[i] + child[i];
            }
        }
    }
}
