package com.justplay1994.github.acm.leetcode;


import java.util.concurrent.LinkedBlockingQueue;

/**
 * 862. 和至少为 K 的最短子数组
 * start 2020/05/30 20:42
 *
 */
public class Solution862 {
    class Solution {
        //双端单调递增队列
        class MonotonicQueue{
            Node head;
            Node tail;
            int size;

            class Node{
                Node next;
                Node pre;
                int index;
                int sum;  //sum(index)

                public Node(int index, int sum){
                    this.index = index;
                    this.sum = sum;
                }
            }

            public void push(Node _node){
                size++;
                if (head == null){
                    head = _node;
                }else {
                    while (tail != null && tail.sum >= _node.sum){
                        tail = tail.pre;
                    }
                    if (tail == null){
                        head = _node;
                    }else {
                        tail.next = _node;
                        _node.pre = tail;
                    }
                }
                tail = _node;
            }

            public void pop(){
                if (size == 1){
                    head = null;
                    tail = null;
                }else {
                    head = head.next;
                }
                size --;
            }
        }

        public int shortestSubarray(int[] A, int K) {
            int result = Integer.MAX_VALUE;
            if (A.length == 0) return -1;
            MonotonicQueue queue = new MonotonicQueue();
            int sum = 0;
            for (int i = 0; i < A.length; i++){
                sum += A[i];
                queue.push(queue.new Node(i,sum));
                while (queue.size > 0 && queue.head.sum - queue.tail.sum + A[queue.head.index] >= K){
                    result = Math.min(result, queue.head.index - queue.tail.index + 1);
                    queue.pop();
                }
            }
            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }
}
