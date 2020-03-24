package com.justplay1994.github.acm.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author huangzezhou
 * @date 2020/3/22
 * 945. 使数组唯一的最小增量
 * start 13:32
 * ac 15:05
 */

public class Solution945 {

    public static void main(String[] args){
        TreeMap map = new TreeMap();
        map.put(3,1);
        map.put(2,1);
        map.put(100,1);
        map.put(1,1);
        Map.Entry entry;
        while ((entry = map.pollFirstEntry()) != null){
            System.out.println(entry);
        }
    }

    class Solution {
        public int minIncrementForUnique(int[] A) {
            if (A.length == 0)return 0;
            int result = 0;
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            for (int i1 : A) {
                treeMap.merge(i1, 1, (a, b) -> a + b);
            }
            Map.Entry<Integer, Integer> entry;
            Map.Entry<Integer, Integer> last;
            entry = treeMap.pollFirstEntry();
            last = entry;
            int curernt = entry.getValue();
            while ((entry = treeMap.pollFirstEntry()) != null){

                if (entry.getKey() - last.getKey() >= curernt){//中间空位完全消费
                    result += curernt * (curernt - 1) / 2;
                    curernt = 0;
                }else {
                    result += (2 * curernt - entry.getKey() + last.getKey() - 1) * (entry.getKey() - last.getKey()) / 2;
                    curernt -= entry.getKey() - last.getKey();
                }
                curernt += entry.getValue();
                last = entry;
            }
            result += curernt * (curernt - 1) / 2;
            return  result ;
        }
    }
}
