package com.justplay1994.github.acm.leetcode;

import java.util.Arrays;

/**
 * @author justplay1994
 * @date 2020-7-26 10:33
 */
public class Solution5472 {
    class Solution {
        public String restoreString(String s, int[] indices) {
            char[] input = s.toCharArray();
            char[] result = new char[s.length()];
            for(int i = 0; i < indices.length; i++){
                result[indices[i]] = input[i];
            }
            return new String(input);
        }
    }

    public static void main(String[] args){
        int[][] a = new int[2][2];
        Arrays.fill(a, 2);
    }
}
