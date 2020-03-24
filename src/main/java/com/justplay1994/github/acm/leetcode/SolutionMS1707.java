package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzezhou
 * @date 2020/3/24
 * 面试题 17.07. 婴儿名字
 * start 9:20
 * ac 15:03
 */

public class SolutionMS1707 {

    public static void main(String[] args){
        String[] result = new Solution().trulyMostPopular(
                new String[]{"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"},
                new String[]{"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"}
                );
        System.out.println(result);
    }

    static
    class Solution {
        //Disjoint Set Union并查集 DSU
        public String[] trulyMostPopular(String[] names, String[] synonyms) {
            HashMap<String, String> dsu = new HashMap<>();

            for (String str: synonyms){
                str = str.substring(1, str.length() - 1);
                String[] nameArr = str.split(",");

                String temp = nameArr[0];
                while (dsu.get(temp) != null && !dsu.get(temp).equals(temp)){
                    temp = dsu.get(temp);
                }
                String temp1 = nameArr[1];
                while (dsu.get(temp1) != null && !dsu.get(temp1).equals(temp1)){
                    temp1 = dsu.get(temp1);
                }
                if (!temp1.equals(temp)){
                    String minStr = min(temp, temp1);
                    dsu.put(nameArr[0], minStr);
                    dsu.put(nameArr[1], minStr);
                    dsu.put(temp, minStr);
                    dsu.put(temp1, minStr);
                }
            }
            HashMap<String, Integer> result = new HashMap<>();
            for (String name: names){
                String temp = name.split("\\(")[0];
                while (dsu.get(temp) != null && !dsu.get(temp).equals(temp)){
                    temp = dsu.get(temp);
                }
                int num = Integer.parseInt(name.split("\\(")[1].replace(")",""));
                result.merge(temp, num, (a, b) -> a+b);
            }
            String[] res = new String[result.size()];

            int x = 0;
            for (Map.Entry<String, Integer> entry: result.entrySet()){
//                res[order.get(entry.getKey())] = entry.getKey() + "(" + entry.getValue() +")";
                res[x] = entry.getKey() + "(" + entry.getValue() +")";
                x++;
            }
            return res;
        }

        public String min(String str1, String str2){
            char[] a1 = str1.toCharArray();
            char[] a2 = str2.toCharArray();
            for (int i = 0; i < Math.min(a1.length, a2.length); i ++){
                if (a1[i] < a2[i]) return str1;
                else if (a1[i] > a2[i])return str2;
            }
            if (a1.length < a2.length){
                return str1;
            }else {
                return str2;
            }
        }
    }
}
