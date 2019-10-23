package com.justplay1994.github.acm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution5057None {
    public int maxSumAfterPartitioning(int[] A, int K) {
        for (int i = 0; i < A.length; i++){
            int start = i - K + 1 >= 0 ? i - K + 1 : 0 ;
            int max = i + K -1 < A.length ? i + K -1 : A.length - 1;
            for (int j = start; j<= max; j++ ){
                PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
                queue.add(A[j]);
            }
        }
        return -1;
    }
}