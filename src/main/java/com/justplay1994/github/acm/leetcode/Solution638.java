package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/12/7
 * 638. 大礼包
 * dp训练
 * start 15:17
 * ac 19:40
 * 印象标签：压状DP
 */

public class Solution638 {

    public static void main(String[] args){
        deal("\n" +
                "[1,10,4,4,6,4]\n" +
                "[[1,1,4,1,4,0,10],[2,3,6,2,3,1,22],[5,2,5,4,0,0,27]]\n" +
                "[2,5,1,1,6,1]");
    }
    static public int deal (String str){
        str = str.replaceAll(" ", "");
        String[] strings = str.split("\\n");
        String[] input = strings[1].substring(1, strings[1].length() - 1).split(",");
        List<Integer> price = new ArrayList<>();
        for (int i = 0; i < input.length; i++){
            price.add(Integer.parseInt(input[i]));
        }

        String[] input1 = strings[3].substring(1, strings[3].length() - 1).split(",");
        List<Integer> needs = new ArrayList<>();
        for (int i = 0; i < input1.length; i++){
            needs.add(Integer.parseInt(input1[i]));
        }


        String[] temp = strings[2].replaceAll("\"","").replaceAll(",\\[","").replaceAll("\\[","").split("]");
        List<List<Integer>> special = new ArrayList<>();
        for (int i = 0; i < temp.length; i++){
            List<Integer> list = new ArrayList<>();
            String[] s = temp[i].split(",");
            for (int j = 0; j < s.length; j++){
                list.add(Integer.parseInt(s[j]));
            }
            special.add(list);
        }
        return new Solution().shoppingOffers(price, special, needs);
    }

static
    class Solution {
        /**
         * 貌似存在这样一个BUG，比较难处理
         * 目前建立的映射关系为：3个bit，代表一类商品的数量，但是极有可能超过后，还进一位了。
         * 因此，需要每次先判断本次购买，是否会使得该类商品超过6个，如果是，则阻止本次购买。
         *
         * 大礼包本身也可能越界，需要屏蔽
         *
         * 由此看来，如果测试用例很乱的话，不宜做映射，因为映射会隐去很多中间状态，导致每一处映射都要做限制。
         * 如果不做映射，只需要在使用处做校验即可，不容易遗漏。
         */
        int result = 0;
        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            for (int i = 0; i < needs.size(); i++) {
                result += needs.get(i) << i * 3;
            }
            if (result == 0) return 0;
            int[] dp = new int[result + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);

            //给礼包剪枝
            List<Integer> remove = new ArrayList<>();
            for (int j = 0; j < special.size(); j++) {
                List<Integer> list = special.get(j);
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) > needs.get(i)) {
                        remove.add(j);
                        break;
                    }
                }
            }
            List<List<Integer>> tempL = new ArrayList<>();
            for (int i = 0; i < special.size(); i++) {
                boolean skip = false;
                for (int j = 0; j < remove.size(); j++) {
                    if (remove.get(j) == i){
                        skip = true;
                    }
                }
                if (!skip){
                    tempL.add(special.get(i));
                }
            }
            special = tempL;


            for (int i = 0; i < 6; i++) {    //6次循环，每次选择一个商品，或者一个礼包
                for (int j = 0; j < price.size(); j++) { //遍历商品类型
                    int add = 1 << j * 3;
                    for (int k = 1; k < dp.length; k++) { //遍历已有策略棋盘
                        if (dp[k] != Integer.MAX_VALUE) {
                            if (buy(k, add)) {
                                int temp = k + add;
                                dp[temp] = Math.min(dp[k] + price.get(j), dp[temp]);
                            }
                        }
                    }
                    if (i == 0) { //单独购买
                        if (buy(0, add)) {
                            dp[add] = Math.min(price.get(j), dp[add]);
                        }
                    }
                }
                for (int j = 0; j < special.size(); j++) {   //遍历礼包类型
                    int cost = special.get(j).get(special.get(j).size() - 1);
                    int add = 0;
                    boolean bad = false;
                    for (int k = 0; k < special.get(j).size() - 1; k++) {
                        if (buy(add, special.get(j).get(k) << k * 3)) {
                            add += special.get(j).get(k) << k * 3;
                        }else {
                            bad = true;
                            break;
                        }
                    }
                    if (bad){
                        continue;
                    }
                    for (int k = 1; k < dp.length; k++) { //遍历已有策略棋盘
                        if (dp[k] != Integer.MAX_VALUE) {
                            if (buy(k, add)) {
                                int index = add + k;
                                dp[index] = Math.min(dp[index], dp[k] + cost);
                            }
                        }
                    }
                    if (i == 0) {    //单独购买
                        if (buy(0,add)) {
                            dp[add] = Math.min(cost, dp[add]);
                        }
                    }
                }
            }
            return dp[result];
        }

        /**
         * 判断本次购买是否有效
         * @param index 之前购买的商品策略
         * @param add 本次购买的商品策略
         * @return
         */
        private boolean buy(int index, int add){
            if (index + add > result) return false;
            int mod = 1 << 3;
            while (add > 0 || index > 0){
                int temp1 = add % mod;
                int temp2 = index % mod;
                if (temp1 + temp2 > 6){
                    return false;
                }
                index = index >> 3;
                add = add >> 3;
            }
            return true;
        }

    }
}
