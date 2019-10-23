package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/8/27
 * 1130-叶值最小代价生成树
 */

/**
 * 动归
 * a[i,k,j] 表示 叶子节点 i ~ j范围，k作为划分点（包含进左子树），划分为左右子树，形成的最小值。
 * 子任务a[i,k,j]任务可以拆解成子任务,并且局部最优推导全局最优
 */
public class Solution1130AC {

    public static void main(String[] args){
        int[] arr = { 11,12,12 };
        int result = new Solution1130AC().mctFromLeafValues(arr);
        System.out.println(result);
    }

    public int mctFromLeafValues(int[] arr){
        Object[][] a= new Object[arr.length][arr.length];
        for (int num = 1; num <= arr.length; num++){   //num = i-j共有多少多少叶子点
            for (int i = 0; i + num - 1 < arr.length; i++){
                int j = i + num - 1;
                if (i == j){
                    a[i][j] = new Leaf(arr[i]);
                    continue;
                }else if ( j - i == 1){
                    a[i][j] = new Triple4(arr[i] * arr[j], new int[]{arr[i], arr[j]});
                    continue;
                }
                //至少包含三个叶节点
                Triple4 minT = null;    //本区间各种划分中，最小值
                //确定划分点,i-划分点（包含），被包含在左子树，右边剩余为右子树
                for (int k = i; k <= j-1; k++){
                    Triple4 temp = leftRight(a[i][k], a[k+1][j]);
                    if (minT == null || temp.min < minT.min){
                        minT = temp;
                    }
                }
                a[i][j] = minT;
            }
        }
        Triple4 root = (Triple4) a[0][arr.length-1];
        return root.min;
    }

    /**
     * 合并左子树和右子树
     * @param _left
     * @param _right
     * @return
     */
    private Triple4 leftRight(Object _left, Object _right){
        Triple4 result = new Triple4();
        MinHeap minHeap = new MinHeap(2);
        if (_left instanceof Leaf){//左子树为叶子节点
            Leaf left = (Leaf) _left;
            Triple4 right = (Triple4) _right;
            minHeap.push(left.value);
            minHeap.push(right.top[0]);
            minHeap.push(right.top[1]);
            result.top[0] = minHeap.top();
            result.top[1] = minHeap.top();
            result.min = result.top[0] * result.top[1] + right.min;
            return result;
        }else if (_right instanceof Leaf){//右子树为叶子节点
            Triple4 left = (Triple4) _left;
            Leaf right = (Leaf) _right;
            minHeap.push(right.value);
            minHeap.push(left.top[0]);
            minHeap.push(left.top[1]);
            result.top[0] = minHeap.top();
            result.top[1] = minHeap.top();
            result.min = result.top[0] * result.top[1] + left.min;
            return result;
        }else {
            Triple4 left = (Triple4) _left;
            Triple4 right = (Triple4) _right;
            minHeap.push(right.top[0]);
            minHeap.push(right.top[1]);
            minHeap.push(left.top[0]);
            minHeap.push(left.top[1]);
            result.top[0] = minHeap.top();
            result.top[1] = minHeap.top();
            result.min = result.top[0] * result.top[1] + left.min + right.min;
            return result;
        }
    }

    private class Leaf {
        /**
         * 本节点的值
         */
        Integer value;

        Leaf(int value){
            this.value = value;
        }
    }

    /**
     * 非叶子节点四元组
     * 所有非叶子节点的孩子叶子树 >=2
     * 因此，Triple4四元组里面一定同时有top1max和top2max
     */
    public class Triple4 {

        /**
         * 该结点及其非叶节点之和
         */
        int min;

        /**
         * 最大两个叶子节点值
         */
        int[] top;

        Triple4(){
            top = new int[2];
        }

        Triple4(int min, int[] top){
            this.min = min;
            this.top = top;
        }
    }

    /**
     * 小顶堆
     */
    public class MinHeap {

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
         * @return
         */
        public int getCapacity() {
            return array.length;
        }

        /**
         * 获取堆当前已使用容量大小
         * @return
         */
        public int getSize() {
            return size;
        }

        /**
         * 入堆
         * @param input
         */
        public void push(int input) {
            if (size + 1 <= array.length) {
                array[size] = input;
                size++;
                heapUp();
            } else {
                if (input > array[0]) {
                    array[0] = input;
                    heapDown();
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
}
