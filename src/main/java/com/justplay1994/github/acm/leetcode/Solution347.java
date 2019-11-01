package com.justplay1994.github.acm.leetcode;

import java.util.*;

/**
 * @author huangzezhou
 * @date 2019/10/30
 * 347. 前 K 个高频元素
 * start 16:12
 * end 16:22
 * one time
 */

public class Solution347 {

    public static void main(String[] args){
        System.out.println(new Solution().topKFrequent(new int[]{1,2,3,2,3,3}, 2));
    }
    static
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                if (map.get(nums[i]) == null){
                    map.put(nums[i], 1);
                }else {
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
            }
            PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
            for (Map.Entry entry: map.entrySet()){
                queue.add(entry);
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++){
                result.add(queue.poll().getKey());
            }
            return result;
        }
    }
}
