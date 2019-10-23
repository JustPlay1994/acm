package com.justplay1994.github.acm.leetcode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author huangzezhou
 * @date 2019/10/23
 * 684. 冗余连接
 * start 22:16
 * ac 23:31
 * One time
 */

public class Solution684 {

    public static void main(String[] args){
        new Solution().findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}});
    }

    static class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            HashMap<Integer, List<Node>> map = new HashMap<>();
            for(int i = 0; i < edges.length; i++){
                if (map.get(edges[i][0]) == null) {
                    ArrayList<Node> list = new ArrayList<>();
                    list.add(new Node(edges[i][1], i));
                    map.put(edges[i][0], list);
                }else {
                    map.get(edges[i][0]).add(new Node(edges[i][1], i));
                }
                if (map.get(edges[i][1]) == null){
                    ArrayList<Node> list = new ArrayList();
                    list.add(new Node(edges[i][0], i));
                    map.put(edges[i][1], list);
                }else {
                    map.get(edges[i][1]).add(new Node(edges[i][0], i));
                }
            }
            LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
            for (Map.Entry<Integer,List<Node>> entry: map.entrySet()){
                if (entry.getValue().size() == 1){
                    queue.add(entry.getKey());
                }
            }
            while (queue.size() != 0){
                Integer integer = queue.poll();
                List<Node> list = map.get(integer);
                for (Node node : list){
                    List<Node> relationList = map.get(node.relation);
                    relationList.removeIf(temp -> temp.relation == integer);

                    if (relationList.size() == 1){
                        queue.offer(node.relation);
                    }
                }
                map.remove(integer);
            }
            int[] result = new int[2];
            int priority = -1;
            for (Map.Entry<Integer, List<Node>> entry: map.entrySet()){
                for (Node node: entry.getValue()){
                    if (priority == -1){
                        priority = node.priority;
                        result[0] = entry.getKey();
                        result[1] = node.relation;
                    }else if (node.priority > priority){
                        priority = node.priority;
                        result[0] = entry.getKey();
                        result[1] = node.relation;
                    }
                }
            }
            if (result[0] > result[1]){
                int temp = result[0];
                result[0] = result[1];
                result[1] = temp;
            }
            return result;
        }
        class Node{
            /**
             * 相关点
             */
            int relation;
            /**
             * 优先级
             */
            int priority;

            Node(int relation, int priority){
                this.relation = relation;
                this.priority = priority;
            }
        }
    }
}
