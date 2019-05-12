package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution5056 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] result = new int[N];
        List[] array = new List[N];
        for (int i = 0; i < paths.length; i++){
            int maxIndex = paths[i][0] > paths[i][1] ? 0 : 1;
            int otherIndex = maxIndex == 0 ? 1 : 0;
            List list = array[paths[i][maxIndex] - 1];
            if (list == null){
                array[paths[i][maxIndex] - 1] = new ArrayList();
            }
            array[paths[i][maxIndex] - 1].add(paths[i][otherIndex] - 1);
        }

        result[0] = 1;
        for (int i = 1; i < array.length; i++){
            int[] color = {1, 1, 1, 1};
            List list = array[i];
            if (list == null){
                result[i] = 1;
                continue;
            }
            for (int j = 0; j < list.size(); j++){
                int hasColor = result[(int) list.get(j)];
                color[hasColor - 1] = 0;
            }
            for (int j = 0; j < color.length; j++){
                if (color[j] == 1){
                    result[i] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] input = {{ 1,2}, {2, 3}, {1, 3}};
        System.out.print(new Solution5056().gardenNoAdj(3, input));
    }
}