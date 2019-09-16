package com.justplay1994.github.acm.leetcode.util;

/**
 * @author huangzezhou
 * @date 2019/8/24
 */

import java.util.ArrayList;

/**
 * 小顶堆
 *
 * 20190916: 增加自动扩容功能
 */
public class MinHeap {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        minHeap.autoResize = true;
        for (int i = 20; i >= 1; i--) {
            minHeap.push(i);
        }
        int size = minHeap.size;
        for (int i = 0; i < size; i++) {
            System.out.println(minHeap.top());
        }
    }

    public boolean autoResize = false;

    int[] array;

    private int size = 0;

    public MinHeap() {
        init(10);
    }

    public MinHeap(int capacity) {
        init(capacity);
    }

    public void init(int capacity) {
        array = new int[capacity];
    }

    /**
     * 获取堆最大容量
     *
     * @return
     */
    public int getCapacity() {
        return array.length;
    }

    /**
     * 获取堆当前已使用容量大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 入堆
     *
     * @param input
     */
    public void push(int input) {
        if (size + 1 <= array.length) {
            array[size] = input;
            size++;
            heapUp();
        } else {
            if (!autoResize) {
                if (input > array[0]) {
                    array[0] = input;
                    heapDown();
                }
            }else {
                //扩容
                int[] temp = new int[array.length * 2];
                for (int i = 0; i < array.length; i++){
                    temp[i] = array[i];
                }
                array = temp;
                array[size] = input;
                size++;
                heapUp();
            }
        }
    }

    /**
     * 向上调整堆
     */
    private void heapUp() {
        int current = size - 1;
        int parent = (current - 1) / 2;
        while (current > 0 && array[current] < array[parent]) {
            int temp = array[current];
            array[current] = array[parent];
            array[parent] = temp;
            current = parent;
            parent = (current - 1) / 2;
        }
    }

    /**
     * 出堆
     *
     * @return
     */
    public int top() {
        if (size < 1) {
            throw new IndexOutOfBoundsException("出堆失败，当前堆内没有元素");
        }
        int result = array[0];
        if (size - 1 > 0) {
            array[0] = array[size - 1];
        }
        size--;
        heapDown();
        return result;
    }

    /**
     * 向下调整堆
     */
    private void heapDown() {
        int current = 0;
        int leftChild = current * 2 + 1;
        while (leftChild < size - 1) {
            int minIndex = leftChild;
            if (leftChild + 1 <= size - 1) {
                minIndex = array[leftChild] < array[leftChild + 1] ? leftChild : leftChild + 1;
            }
            if (array[minIndex] < array[current]) {
                int temp = array[minIndex];
                array[minIndex] = array[current];
                array[current] = temp;
                current = minIndex;
            } else {
                break;
            }
            leftChild = current * 2 + 1;
        }
    }
}
