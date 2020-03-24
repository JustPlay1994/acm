package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangzezhou
 * @date 2019/11/1
 * 1125. 最小的必要团队
 * start: 21:10
 * end 23:18
 */

public class Solution1125 {
    class Solution {

        /*
        a[i] = 最少人数。 i 表示技能组合。
        a[index(people[i], a[j])] = Max (a[j] + 1, a[index(people[i], a[j])])
        特别的
        a[index(people[i])] = 1;
        其他的都为0
         */
        public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
            //技能对应下标
            HashMap<String, Integer> skillIndex = new HashMap();
            for (int i = 0; i < req_skills.length; i++){
                skillIndex.put(req_skills[i], i);
            }
            int[] dp = new int[1 << req_skills.length];
            dp[0] = 0;
            HashMap<Integer, List<Integer>> mapPeople = new HashMap<>();
            for (int i = 0; i < people.size(); i++){
                List<String> skills = people.get(i);
                int index = 0;
                for (int j = 0; j < skills.size(); j++){
                    if (skillIndex.get(skills.get(j)) != null) {
                        index = index | 1 << skillIndex.get(skills.get(j));
                    }
                }

                for (int j = 0; j < dp.length; j++){
                    if (dp[j] == 0){
                        continue;
                    }
                    if (dp[index | j] == 0 || dp[index | j] > dp [j] + 1){
                        dp[index | j] = dp[j] + 1;
                        List<Integer> list = new ArrayList<>();
                        list.addAll(mapPeople.get(j));
                        list.add(i);
                        mapPeople.put(index | j, list);
                    }
                }
                dp[index] = 1;
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mapPeople.put(index, list);
            }
            List<Integer> list = mapPeople.get(dp.length - 1);
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++){
                result[i] = list.get(i);
            }
            return result;
        }
    }
    /*
        组合如何表示用值（对象）表示；
        1. 零组合，0个元素
        2. 当前组合，得到一个组合值（对象）
        3. 相同的组合，得到的组合值（对象）相同
        4. 组合值支持，新增元素的操作
        最好用位表示，位运算取或操作，相当于求并集。
        集合尽量用位。


        在遍历的时候，常常要发生变化时，尽量不要使用集合，不支持遍历时变化，而使用数组。
        在不知道大小的时候，可选择集合省事。
         */
}
