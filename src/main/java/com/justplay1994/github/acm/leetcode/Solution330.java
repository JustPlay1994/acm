package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/8/28
 * 330.按要求补齐数组
 */

import java.util.*;

/**
 * 思路:https://blog.csdn.net/u013014636/article/details/100386673
 */
public class Solution330 {
    static long start = 0;
    public static void main(String[] args){
        start = System.currentTimeMillis();
        new Solution330().minPatches(new int[]{1,1,1,1,2,2,2,3,3,3,3,3,4,4,4,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,8,8,8,8,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,12,12,12,12,13,13,13,14,14,14,14,14,14,14,15,15,15,15,15,15,16,16,16,16,16,16,16,16,17,17,17,17,17,17,18,18,18,18,18,18,19,19,19,20,20,21,21,21,21,21,21,21,22,22,22,22,22,22,22,22,22,22,23,23,23,23,24,24,24,24,24,25,25,25,25,26,26,26,26,27,27,27,27,27,27,28,28,29,29,29,29,29,29,30,30,30,30,31,31,31,31,31,31,32,32,32,32,32,32,32,32,33,33,33,33,34,34,34,34,34,34,34,35,35,35,35,35,35,36,36,37,37,38,38,38,38,39,39,39,39,40,40,40,40,40,41,41,41,41,41,41,41,42,42,42,42,42,42,43,43,43,43,43,43,43,44,44,44,44,44,44,45,45,45,45,45,46,46,46,47,47,47,47,48,48,48,48,48,48,48,49,49,49,50,50,50,50,51,52,52,52,52,52,53,53,53,53,53,53,54,54,54,54,55,55,55,55,56,56,56,56,57,57,57,57,57,57,57,57,58,58,58,58,58,58,58,59,59,59,60,60,60,60,61,61,61,61,61,61,62,62,62,62,62,62,63,63,63,63,63,64,64,65,65,65,65,66,66,66,66,66,67,67,67,67,67,68,68,68,68,68,69,69,69,69,69,69,69,70,70,70,71,71,71,71,71,72,72,72,72,72,73,73,73,73,73,73,73,74,74,74,74,74,74,74,74,75,75,75,75,75,75,75,75,76,76,76,76,77,77,77,78,78,78,78,78,79,79,79,80,80,80,80,80,80,81,81,81,81,81,81,82,82,82,82,82,82,83,83,83,83,83,83,84,84,84,85,85,85,85,85,85,86,86,86,86,86,86,87,87,87,87,87,87,88,88,88,89,89,89,90,90,90,90,90,90,90,91,92,92,92,92,93,93,93,93,93,94,94,94,94,95,95,95,95,95,96,96,96,96,96,97,97,97,97,97,97,98,98,98,98,98,98,98,99,99,99,99,99,99,99,99,99,99,100,100}, 63160);//2
//        new Solution330().minPatches(new int[]{1,3}, 6);
//        new Solution330().minPatches(new int[]{1,1,1,1,1,1,1,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,10,10,10,10,10,10,10,11,11,11,11,11,12,12,12,12,12,13,13,13,13,13,13,13,13,13,13,14,14,14,14,14,14,14,14,14,14,14,14,14,15,15,15,15,15,15,15,16,16,16,16,16,16,16,16,16,17,17,17,17,17,17,17,17,17,17,17,17,17,18,18,18,18,18,18,18,19,19,19,19,19,19,19,19,19,19,19,20,20,20,20,20,20,20,20,20,20,20,21,21,21,21,21,22,22,22,22,22,23,23,23,23,23,23,24,24,24,24,24,25,25,26,26,26,26,26,26,26,26,27,27,28,28,28,28,28,28,28,28,28,28,28,28,29,29,29,29,30,30,31,31,31,31,31,32,32,32,32,32,32,32,32,33,33,33,33,33,33,33,34,34,34,34,34,34,34,34,34,34,34,35,35,35,35,35,35,36,36,36,36,36,36,37,37,37,37,37,37,37,37,37,38,38,38,38,38,39,39,39,39,39,39,39,39,39,39,40,40,40,40,41,41,41,41,41,41,41,41,41,41,42,42,42,42,42,42,43,43,43,43,43,43,43,43,43,44,44,44,44,44,44,44,45,45,45,45,45,46,46,46,46,47,47,47,47,47,47,47,48,48,48,48,48,48,48,48,48,49,49,49,49,49,49,49,50,50,50,50,50,50,50,50,51,51,51,51,51,51,51,51,51,52,52,52,52,52,52,53,53,53,53,53,54,54,54,54,54,54,54,54,54,55,55,55,55,55,55,55,56,56,56,56,56,56,56,56,56,56,57,57,57,57,57,57,57,57,57,57,58,58,58,58,58,59,59,59,59,59,59,59,59,59,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,61,61,61,61,61,61,61,62,62,62,62,62,62,62,62,62,62,63,63,63,63,63,63,63,63,63,63,64,65,65,65,65,65,66,66,66,67,67,67,67,67,67,67,67,67,68,68,68,69,69,69,69,69,69,70,70,70,70,70,71,71,71,71,71,71,71,71,72,72,72,72,72,73,73,73,73,73,73,74,74,74,74,74,74,74,74,74,75,75,75,75,75,75,75,75,75,76,76,76,76,76,76,76,77,77,77,77,78,78,78,78,78,78,78,78,78,78,78,79,79,79,79,80,80,80,80,80,80,81,81,81,81,81,82,82,82,82,82,82,82,82,83,83,83,83,83,83,84,84,84,84,85,85,85,85,85,86,86,86,86,86,86,87,87,87,87,88,88,88,88,88,88,88,88,88,88,89,89,89,89,90,90,90,90,90,90,91,91,91,91,91,91,91,91,91,92,92,92,93,93,93,93,93,93,93,93,94,94,94,94,94,94,94,95,95,95,95,95,95,96,96,96,96,96,96,96,96,96,96,96,97,97,97,97,97,97,97,98,98,98,98,98,99,99,99,99,99,99,100,100,100,100,100},39473);
        System.out.println(System.currentTimeMillis() - start);
    }

    public int minPatches(int[] nums, int n) {
        int result = 0;
        //缺口，可以是无须的，因为互斥
        HashMap<Integer, Triple2> space = new HashMap<>();
        space.put(1, new Triple2(1, n));
        //缺口形成阶段
        //计算分布情况
        for (int i = 0; i < nums.length; i++){
            HashMap<Integer, Triple2> temp = (HashMap<Integer, Triple2>) space.clone();
            for (Integer integer: temp.keySet()){
                Triple2 triple2 = space.get(integer);
                //如果该缺口包含数字本身，优先填充数据本身，再填充数字范围
                //填充数字本身（相当于现有数字都不选，只选本数字），填范围，然后合并
                if (triple2.start <= nums[i] && triple2.start + n - 1 >= nums[i]){
                    if (triple2.start == nums[i]){
                        if (space.get(integer).length > 1) {
                            space.put(integer + 1, new Triple2(integer + 1, triple2.length - 1));
                        }
                        space.remove(integer);
                    }else if (triple2.start + n - 1 == nums[i]){
                        space.get(integer).length -=1;
                        if (space.get(integer).length <= 1) space.remove(integer);
                    }else {
                        //左缺口
                        space.put(triple2.start, new Triple2(triple2.start, nums[i] - triple2.start));
                        //右缺口
                        space.put(nums[i] + 1, new Triple2(nums[i] + 1, triple2.length - space.get(triple2.start).length - 1));
                        //移除之前的缺口
                        space.remove(triple2.start);
                    }
                }else {
                    //填充其他缺口的范围。
                    if (triple2.length - nums[i] > 0){
                        space.get(integer).length -= nums[i];
                    }else {
                        space.remove(integer);
                    }
                }
            }
        }

        ArrayList<Map.Entry<Integer, Triple2>> spaceList = new ArrayList<>(space.entrySet());
        Collections.sort(spaceList, new Comparator<Map.Entry<Integer, Triple2>>() {
            @Override
            public int compare(Map.Entry<Integer, Triple2> o1, Map.Entry<Integer, Triple2> o2) {
                return o1.getKey()- o2.getKey();
            }
        });
        //填补缺口阶段，缺口需要有序
        while (spaceList.size() > 0){
            //每次填一个最佳数字
            result++;
            //获取第一个接口
            Triple2 triple2 = spaceList.get(0).getValue();
            int addLength = triple2.start;
            Iterator<Map.Entry<Integer, Triple2>> iterator = spaceList.iterator();
            //对现有缺口带来的影响进行处理
            while (iterator.hasNext()){
                Triple2 temp = iterator.next().getValue();
                if (addLength >= temp.length){
                    iterator.remove();
                }else {
                    temp.length = temp.length - addLength;
                    temp.start = temp.start + addLength;
                }
            }
        }

        return result;
    }

    /**
     * 二元组，表示一个连续空缺
     */
    class Triple2{

        /**
         * 空缺开始数值，从1开始，最大为n
         */
        int start;

        /**
         * 空缺长度
         */
        int length;

        Triple2(int start, int length){
            this.start = start;
            this.length = length;
        }

        public String toString(){
            return start + "," + length;
        }
    }
}
