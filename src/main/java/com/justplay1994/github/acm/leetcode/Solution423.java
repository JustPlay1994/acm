package com.justplay1994.github.acm.leetcode;

import java.util.*;

/**
 * @author huangzezhou
 * @date 2019/10/25
 * 423. 从英文中重建数字
 * start 14:52
 * pause: 15:15
 * start 15:25
 * pause: 16:00
 */

public class Solution423 {

    public static void main(String[] args){
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        System.out.println();
    }

    class Solution {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", " seven", "eight", "nine", "ten"};

        /*
        只有一个的
        g 8
        u 4
        w 2
        x 6
        z 0
         */
        public String originalDigits(String s) {
            HashMap<Integer, Integer> input = new HashMap<>();
            for (int i = 0; i < s.length(); i++){
                int c = s.charAt(i);
                if (input.get(c) == null){
                    input.put(c,1);
                }else {
                    input.put(c, input.get(c) + 1);
                }
            }


            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++){
                for (int j = 0; j < numbers[i].length(); j++) {
                    int c = numbers[i].charAt(j);
                    if (map.get(c) == null) {
                        List<Integer> list = new ArrayList<>();
                        map.put(c, list);
                    }
                    map.get(c).add(i);
                }
            }

            return null;
        }

        public void delete (HashMap<Integer, Integer> map, String word){
            for (int i = 0; i < word.length(); i++){
                int c = word.charAt(i);
                if (map.get(c) > 0){
                    map.put(c, map.get(c) - 1);
                }
            }
        }


    }
}
