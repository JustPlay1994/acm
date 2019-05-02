package com.justplay1994.github.acm.leetcode;

/**
 * Created by JustPlay1994 on 2019/4/30.
 * https://github.com/JustPlay1994
 */

import java.util.PriorityQueue;

/**
 * 数据流中的第K大元素
 * KthLargest
 */
public class Solution703 {

    MinHeap minHeap;

    public Solution703(int k, int[] nums) {
        minHeap = new MinHeap(k);
        for (int i = 0; i < nums.length; ++i){
            minHeap.push(nums[i]);
        }
    }

    public int add(int val) {
        minHeap.push(val);
        System.out.println(minHeap.min());
        return minHeap.min();
    }

    /**
     * 小顶堆:
     */
    class MinHeap {

        /**
         * 最后一个元素下标+1
         */
        int heapSize = 0;
        int[] nums;

        public MinHeap(int capacity){
            nums = new int[capacity];
        }

        public void push(int data){
            if (heapSize == nums.length){
                if (data > nums[0]){
                    nums[0] = data;
                    downAdjust(0);
                }
            }else {
                nums[heapSize] = data;
                heapSize++;
                upAdjust(heapSize-1);
            }
        }

        public int min(){
            return heapSize > 0 ? nums[0] : -1;
        }

        public int pop(){
            if (heapSize == 0){
                return -1;
            }
            int result = nums[0];
            if (heapSize > 1){
                nums[0] = nums[heapSize - 1];
                adjust();
            }
            heapSize--;
            return result;
        }

        /**
         * 全调整
         */
        public void adjust(){
            for (int i = heapSize - 1; i >= 1; ){
                int minIndex;
                if ((heapSize-1) % 2 == 0){
                    minIndex = nums[i] < nums[i-1] ? i : i-1;
                    i -= 2;
                }else {
                    minIndex = i;
                    i -= 1;
                }
                int parentIndex= (minIndex+1) / 2 - 1;
                if ( nums[minIndex] < nums[parentIndex]){
                    int t = nums[parentIndex];
                    nums[parentIndex] = nums[minIndex];
                    nums[minIndex] = t;
                }
            }
        }


        /**
         * 向上调整
         * @param index
         */
        public void upAdjust(int index){
            int minIndex;
            if (index == 0) {
                return;
            }
            if (index % 2 == 0){
                int rightChildIndex = index;
                int leftChildIndex = index - 1;
                minIndex = nums[leftChildIndex] < nums[rightChildIndex] ? leftChildIndex : rightChildIndex;
            }else {
                minIndex = index;
            }
            int parentIndex = ((index + 1) >> 1) - 1;
            if ( nums[minIndex] < nums[parentIndex] ){
                int t = nums[parentIndex];
                nums[parentIndex] = nums[minIndex];
                nums[minIndex] = t;
                upAdjust(parentIndex);
            }
        }


        /**
         * 向下调整
         * @param index
         */
        public void downAdjust(int index){
            int leftChildIndex = (index << 1) + 1;
            int rightChildIndex = (index << 1) + 2;
            int minChildIndex;
            if (rightChildIndex < heapSize){
                minChildIndex = nums[leftChildIndex] < nums[rightChildIndex] ? leftChildIndex : rightChildIndex;
            }else if (leftChildIndex < heapSize){
                minChildIndex = leftChildIndex;
            }else {
                return;
            }
            if (nums[minChildIndex] < nums[index]){
                int t = nums[minChildIndex];
                nums[minChildIndex] = nums[index];
                nums[index] = t;
                downAdjust(minChildIndex);
            }
        }
    }

    public static void main(String[] args){

        int k = 3;
        int[] arr = {4,5,8,2};
        Solution703 kthLargest = new Solution703(3, arr);
        kthLargest.add(3);   // returns 4
        kthLargest.add(5);   // returns 5
        kthLargest.add(10);  // returns 5
        kthLargest.add(9);   // returns 8
        kthLargest.add(4);   // returns 8
    }
}
