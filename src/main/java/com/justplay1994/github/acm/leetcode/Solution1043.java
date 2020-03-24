package com.justplay1994.github.acm.leetcode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangzezhou
 * @date 2019/11/23
 * 1043. 分隔数组以得到最大和
 * start 11:22
 */

/*
解法一：排序，然后贪心
解法一点五：优化一下，直接贪
解法如下：
遍历每个数值，数值在可影响范围内，选择最大提升的方案，刷新得到结果数组
下一个节点做同样操作，如果发现可影响范围内，最大提升方案冲突，则大的优先。
不行，例如上一个节点最优方案，被下一个更大的全覆盖了，那么上一个节点就不是最优了，那个节点的影响范围就被浪费了。

一次遍历肯定不行：7,8,1,1,9,1,10,1

贪心不行，就试试动归
动归没思路，硬贪。

既然后面更大的会覆盖前面的，浪费前面的影响力，那么再回去把上一个影响力补回来，那有可能一直递归到最开始一个节点。
极端情况：o(n^2)，根解法一差不多，但是平均复杂度肯定会好一些。
有存在影响上两个节点的嘛？应该不会，两个影响力节点如果都在这一次影响范围内，那么他们就一定只是一个影响节点。

封存这个逻辑吧，说实话，写到这里就觉得没意义了，过于复杂。

软件过于复杂就跟算法过于复杂一样，多半不是现实那么复杂，而是设计有问题，简单而美才是算法设计的追求。
就跟DFS一样，深度太深就放弃该分支，太复杂就放弃该算法设计。

回头想一想，贪心既然想不出，但是又感觉是贪心，就退一步，因为所有贪心都可以是动归，因此考虑动归。
算了先A吧，目前才50战力不到，先最求数量，再追求质量。

 */
public class Solution1043 {

    public static void main(String[] args){
        new Solution().maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10},3);
    }

    static
    class Solution {
        public int maxSumAfterPartitioning(int[] A, int K) {
            int[] result = new int[A.length];
            List<Integer> index = new ArrayList();
            int total = 0;
            for (int i = 0; i < A.length; i++){
                index.add(i);
                result[i] = A[i];
                total +=result[i];
            }
            Collections.sort(index, (o1, o2) -> A[o2] - A[o1]);
            for (int i = 0; i < index.size(); i++){
                int start = Math.max(i - K + 1, 0);
                int end = Math.min(i + K - 1, A.length - 1);
                final int temp_i = i;
                if (result[i] != A[i])continue;
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((Comparator<Integer>) (o1, o2) -> {
                    return (result[temp_i] - result[o2]) - (result[temp_i] - result[o1]);
                });
                for (int j = start; j <= end; j++){
                    priorityQueue.add(j);
                }
                for (int j = 0; j < K - 1; j++) {
                    Integer temp = priorityQueue.poll();
                    if (temp == null) break;
                    if (A[temp_i] - A[temp] > 0){
                        result[temp] = A[i];
                        total += A[temp_i] - A[temp];
                    }
                }
            }
            return total;
        }
    }



//    class Solution {
//        public int maxSumAfterPartitioning(int[] A, int K) {
//            int[] operate = new int[A.length];
//            int[] result = new int[A.length];
//            for (int i = 0; i < A.length; i++){
//                operate[i] = i;
//                result[i] = A[i];
//            }
//            for (int i = 0; i < A.length; i++){
//                int start = Math.max(i - K + 1, 0);
//                int end = Math.min(i + K - 1, A.length - 1);
//                final int index = i;
//                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((Comparator<Integer>) (o1, o2) -> {
//                    return (A[index] - A[o1]) - (A[index] - A[o2]);
//                });
//                for (int j = start; j <= end; j++){
//                    priorityQueue.add(j);
//                }
//                //如果本节点被影响，就直接跳过
//                if (operate[i] != i) continue;
//                int p = 0;   //前一个因子的下标
//                int size = 0;   //需要调整前一个因子的范围
//                for (int j = 0; j < K; j++){
//                    Integer temp = priorityQueue.poll();
//                    if (temp == null) break;
//                    if (temp > 0){
//                        result[temp] = A[i];    //本节点被影响因子
//                        if (operate[temp] != temp){
//                            p = operate[temp];
//                            //需要调整前一个因子的范围
//                            size++;
//                        }
//                        operate[temp] = i;  //本节点未被其他因子影响
//                    }
//                }
//                LinkedBlockingQueue queue = new LinkedBlockingQueue();
//                //逐个调整前面被影响的因子
//                while(true){
//                    int temp = p;
//                    while (temp >= 0){
//                        if (operate[temp] != p){
//                            if (result[temp] < A[p]){
//
//                            }
//                        }
//                        continue;
//                    }
//                }
//            }
//        }
//    }
}


