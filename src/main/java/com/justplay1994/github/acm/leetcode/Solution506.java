package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangzezhou
 * @date 2019/11/4
 * 506. 相对名次
 * start 17:34
 * end 18:03
 */

public class Solution506 {
    public static void main(String[] args){
        System.out.println(new Solution().findRelativeRanks(new int[]{5,4,3,2,1}));
    }
    static
    class Solution {

        public String[] findRelativeRanks(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++){
                map.put(i, nums[i]);
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            sort(list, 0 ,nums.length);
            String[] result = new String[nums.length];
            for (int i = 0; i < nums.length; i++){
                list.get(i).setValue(i);
            }
            for (int i = 0; i < nums.length; i++){
                int num = map.get(i);
                if (num == 0) {
                    result[i] = "Gold Medal";
                }else if (num == 1){
                    result[i] = "Silver Medal";
                }else if (num == 2){
                    result[i] = "Bronze Medal";
                }else {
                    result[i] = (num+1)+"";
                }
            }
            return result;
        }

        public void sort(List<Map.Entry<Integer, Integer>> list, int start, int end){
            if (start >= end) return;

            int left = start;
            int right = end - 1;
            while (left < right){
                while (left < right && list.get(left).getValue() > list.get(right).getValue()){
                    left++;
                }
                Map.Entry<Integer, Integer> temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
                while (left < right && list.get(left).getValue() >= list.get(right).getValue()){
                    right--;
                }
                temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
            }
            sort(list, start, left);
            sort(list, left + 1, end);
        }
    }
}
