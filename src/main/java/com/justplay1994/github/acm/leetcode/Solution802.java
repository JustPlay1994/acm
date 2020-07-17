package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author justplay1994
 * @date 2020-7-17 20:44
 */
public class Solution802 {
    class Solution {

        int[][] graph;
        Set<Integer> unsafe = new HashSet<>();

        //dfs
        public List<Integer> eventualSafeNodes(int[][] graph) {
            this.graph = graph;
            for(int i = 0; i < graph.length; i++){
                if(graph[i].length > 0){
                    isSafe(i, new HashSet<String>());
                }
            }
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < graph.length; i++){
                if(unsafe.contains(i)) continue;
                list.add(i);
            }
            return list;
        }

        private boolean isSafe(int input, HashSet<String> set){
            int[] dist = graph[input];
            for(int dist_i: dist){
                if(unsafe.contains(input)){
                    unsafe.add(input);
                    return false;
                }
                String line = input+","+dist_i;
                if(set.contains(line)) {
                    unsafe.add(input);
                    return false;
                }
                HashSet<String> temp = (HashSet)set.clone();
                temp.add(line);
                if(!isSafe(dist_i, temp)) {
                    unsafe.add(input);
                    return false;
                }
            }
            return true;
        }
    }
}
