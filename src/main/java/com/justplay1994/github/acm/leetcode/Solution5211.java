package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author justplay1994
 * @date 2020-7-12 11:25
 */
public class Solution5211 {

    public static void main(String[] args){
        new Solution5211().new Solution().maxProbability(9, new int[][]{{0,1}, {1,2}, {0,2}}, new double[]{0.5, 0.5, 0.2},  7, 8);
    }

    class Solution {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        double result = 0;
        int end;
        int[][] edges;
        double[] succProb;
        double[] cur;
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            this.end = end;
            this.edges = edges;
            this.succProb = succProb;
            for(int i = 0; i < edges.length; i++){
                HashMap<Integer, Integer> temp = map.get(edges[i][0]);
                if (map.get(edges[i][0]) == null) {
                    temp = new HashMap<>();
                }
                temp.put(edges[i][1], i);
                map.put(edges[i][0], temp);


                HashMap<Integer, Integer> temp1 = map.get(edges[i][1]);
                if (temp1 == null) {
                    temp1 = new HashMap<>();
                }
                temp1.put(edges[i][0], i);
                map.put(edges[i][1], temp1);
            }
            cur = new double[n];
            return result;
        }



    }
}
