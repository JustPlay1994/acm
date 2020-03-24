package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2020/3/8
 * 5354. 通知所有员工所需的时间
 * start 11:04
 * end 11:28
 */

public class Solution5354 {

    class Solution {

        class Node{
            int val;
            List<Node> children = new ArrayList<>();

            public Node(int val){
                this.val = val;
            }
        }

        int result = 0;
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            Node[] nodeList = new Node[manager.length];
            for (int i = 0; i < manager.length; i++){
                nodeList[i] = new Node(informTime[i]);
            }
            for (int i = 0; i < manager.length; i++){
                if (i == headID) continue;
                nodeList[manager[i]].children.add(nodeList[i]);
            }

            recursive(0, nodeList[headID]);
            return result;
        }

        public void recursive(int time, Node node){
            result = Math.max(result, time + node.val);
            for (int i = 0; i < node.children.size(); i++){
                recursive(time + node.val, node.children.get(i));
            }
        }
    }
}
