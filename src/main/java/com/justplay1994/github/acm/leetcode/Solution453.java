package com.justplay1994.github.acm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huangzezhou
 * @date 2019/10/25
 * 453. 最小移动次数使数组元素相等
 * start 17:03
 * pause 17:30
 * start 22:19
 *
 */

public class Solution453 {

    public static void main(String[] args){
        System.out.println(new Solution().minMoves(new int[]{1,2,3}));
    }
static
    class Solution {

        public int minMoves(int[] nums) {
            int result = 0;
            while (!isFinished(nums)){
                int[] except = getMax(nums);
                add(nums, except);
                result += except[0] - except[1];
            }
            return result;
        }

        public int[] getMax(int[] nums){
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(((o1, o2) -> o2 - o1));
            for (int i = 0; i < nums.length; i++){
                priorityQueue.add(nums[i]);
            }
            int[] result = new int[2];
            result[0] = priorityQueue.poll();
            result[1] = priorityQueue.poll();
            while (result[0] == result[1]) {
                result[1] = priorityQueue.poll();
            }
            return result;
        }

        public void add(int[] nums, int[] except){
            boolean onlyOne = true;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] == except[0] && onlyOne) {
                    onlyOne = false;
                    continue;
                }
                nums[i] += except[0] - except[1];
            }
        }

        public boolean isFinished(int[] nums){
            int temp = nums[0];
            for (int i = 1; i < nums.length; i++){
                if (nums[i] != temp){
                    return false;
                }
            }
            return true;
        }
    }

}
