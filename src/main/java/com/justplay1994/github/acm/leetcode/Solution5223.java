package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/10/13
 * 5223. 可以攻击国王的皇后
 */

public class Solution5223 {

    public static void main(String[] args){
        new Solution().queensAttacktheKing(new int[][]{{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}}, new int[]{0,0});
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            boolean isAdd;
            //8个方向
            for (int[] queen : queens) {
                isAdd = true;
                if (direction(int2List(queen), king).equals("ERROR")) {
                    isAdd = false;
                }else {
                    for (List<Integer> temp : result) {
                        if (direction(temp, king).equals(direction(int2List(queen), king))) {
                            isAdd = false;
                            if (!isFurther(queen, temp, king)) {
                                temp.set(0, queen[0]);
                                temp.set(1, queen[1]);
                            }
                        }

                    }
                }
                if (isAdd) {
                    List<Integer> add = new ArrayList<>();
                    add.add(queen[0]);
                    add.add(queen[1]);
                    result.add(add);
                }
            }
            return result;
        }

        /**
         * a是否比b离king更远
         * @param a
         * @param b
         * @param king
         * @return
         */
        public boolean isFurther(int[] a, List<Integer> b, int[] king){
            return (a[0] - king[0])*(a[0] - king[0]) + (a[1] - king[1])*(a[1] - king[1])
                    > (b.get(0) - king[0])*(b.get(0) - king[0]) + (b.get(1) - king[1])*(b.get(1) - king[1]);
        }

        public List<Integer> int2List(int[] input){
            List<Integer> result= new ArrayList<>();
            result.add(input[0]);
            result.add(input[1]);
            return result;
        }

        /**
         * 判断在八个方向中的哪一个方向
         * @param b
         * @param king
         * @return
         */
        public String direction(List<Integer> b, int[] king){
            if (b.get(0) == king[0] && b.get(1) > king[1]){
                return "R";
            }
            if (b.get(0) == king[0] && b.get(1) < king[1]){
                return "L";
            }
            if (b.get(1) == king[1] && b.get(0) < king[0]){
                return "U";
            }
            if (b.get(1) == king[1] && b.get(0) > king[0]){
                return "D";
            }
            if (Math.abs(b.get(0) - king[0]) == Math.abs(b.get(1) - king[1])){
                if (b.get(0) < king[0] && b.get(1) < king[1]){
                    return "LU";
                }
                if (b.get(0) < king[0] && b.get(1) > king[1]){
                    return "RU";
                }
                if (b.get(0) > king[0] && b.get(1) < king[1]){
                    return "LD";
                }
                if (b.get(0) > king[0] && b.get(1) > king[1]){
                    return "RD";
                }
            }
            return "ERROR";
        }
    }
}
