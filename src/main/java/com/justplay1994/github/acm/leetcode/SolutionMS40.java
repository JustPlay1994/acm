package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 面试题40. 最小的k个数
 * start 8:57
 */

public class SolutionMS40 {

    class Solution {
        class MaxStack{
            int[] a;
            int size;

            MaxStack(int capacity){
                a = new int[capacity];
            }

            public void add(int val){
                if (size < a.length){
                    a[size] = val;
                    size++;
                    int cur = size - 1;
                    int parent = (cur - 1) / 2;
                    while (cur != parent && a[cur] > a[parent]){
                        int temp = a[cur];
                        a[cur] = a[parent];
                        a[parent] = temp;
                        cur = parent;
                        parent = (cur - 1) / 2;
                    }
                }else if (size > 0){
                    if (val < a[0]){
                        a[0] = val;
                        int cur = 0;
                        int left = (cur + 1) * 2 - 1;
                        while (left < size){
                            if (left + 1 < size){
                                if (a[left] > a[cur] && a[left] > a[left + 1]){
                                    int temp = a[cur];
                                    a[cur] = a[left];
                                    a[left] = temp;
                                    cur = left;
                                    left = (cur + 1) * 2 - 1;
                                }else if (a[left + 1] > a[cur]){
                                    int temp = a[cur];
                                    a[cur] = a[left + 1];
                                    a[left + 1] = temp;
                                    cur = left + 1;
                                    left = (cur + 1) * 2 - 1;
                                }else {
                                    return;
                                }
                            }else {
                                if (a[left] > a[cur]) {
                                    int temp = a[cur];
                                    a[cur] = a[left];
                                    a[left] = temp;
                                    cur = left;
                                    left = (cur + 1) * 2 - 1;
                                }else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        public int[] getLeastNumbers(int[] arr, int k) {
            MaxStack stack = new MaxStack(k);
            for (int i = 0; i < arr.length; i++){
                stack.add(arr[i]);
            }
            return stack.a;
        }
    }
}
