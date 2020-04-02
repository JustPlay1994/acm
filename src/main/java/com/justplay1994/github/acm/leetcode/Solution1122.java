package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 1122. 数组的相对排序
 * start 15:19
 * ac 15:33
 */

public class Solution1122 {

    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer,Integer> map = new HashMap();
            PriorityQueue<Integer> queue = new PriorityQueue();
            for (int i = 0; i < arr2.length; i++){
                map.put(arr2[i],0);
            }
            for (int i = 0; i < arr1.length; i++){
                if (map.get(arr1[i]) == null){
                    queue.add(arr1[i]);
                }else {
                    map.put(arr1[i], map.get(arr1[i]) + 1);
                }
            }
            int i = 0;
            for (int k = 0; k < arr2.length; k++){
                for (int j = 0; j < map.get(arr2[k]); j++){
                    arr1[i] = arr2[k];
                    i++;
                }
            }
            while (queue.size() > 0){
                arr1[i] = queue.poll();
                i++;
            }
            return arr1;
        }
    }

}
