package com.justplay1994.github.acm.leetcode;

/**
 * Created by JustPlay1994 on 2019/4/27.
 * https://github.com/JustPlay1994
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全排列
 */
public class Solution256 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> temp = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
        recursion(new ArrayList<>(), temp);
        return result;
    }

    public void recursion(ArrayList<Integer> res, ArrayList<Integer> others){
        if (others.size() == 0){
            result.add(res);
        }
        for (int i = 0; i < others.size(); ++i){
            ArrayList<Integer> temp_others = (ArrayList<Integer>) others.clone();
            temp_others.remove(i);
            ArrayList<Integer> temp_res = (ArrayList<Integer>) res.clone();
            temp_res.add(others.get(i));
            recursion(temp_res, temp_others);
        }
    }

}
