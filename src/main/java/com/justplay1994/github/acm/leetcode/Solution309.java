package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;

/**
 * @author huangzezhou
 * @date 2019/11/23
 * 309. 最佳买卖股票时机含冷冻期
 * start 10:12
 * pause 10:50
 */

public class Solution309 {

    public static void main(String[] args){
        new Solution309().new Solution().maxProfit(new int[]{6,1,3,2,4,7});
    }
    //伪DP，其实不叫DP。记录每一天的状态，达到遍历全覆盖，又好像用到了前面的最优解，貌似是个DP。这个问题在于，持有状态的时候，需要存储前面所有的情况。
    //可以解决，引入潜在收益就可以解决持有的问题。收益包括实际收益和潜在收益，潜在收益只在持有计算，这样持有只需要保存最优值即可，也不需要保存买入的哪一个。
    class Solution {
        int[][] dp;
        int[] prices;
        public int maxProfit(int[] prices) {
            if (prices.length == 0){
                return 0;
            }
            int result = 0;
            dp = new int[prices.length][5];//-1不可能，0无状态，1持有，2冷冻，3卖出，4买入（状态不能少，否则会漏掉最优解，要覆盖全）
            this.prices = prices;
            dp[0][0] = 0;
            dp[0][1] = -1;
            dp[0][2] = -1;
            dp[0][3] = -1;
            dp[0][4] = 0;
            for (int i =  1; i < prices.length; i++){
                //无状态前序：无状态、冷冻
                dp[i][0] = max(dp[i-1][0], dp[i-1][2]);
                //持有前序状态：买入、持有
                dp[i][1] = max(dp[i-1][4] + prices[i] - prices[i-1], dp[i-1][1] + prices[i] - prices[i - 1]);
                //冷冻前序：卖出
                dp[i][2] = dp[i-1][3];
                //卖出前序：持有、买入
                dp[i][3] = max(dp[i-1][4] + prices[i] - prices[i-1],
                        dp[i-1][1] + prices[i] - prices[i-1]
                        );
                //买入前序：无状态、冷却
                dp[i][4] = max(dp[i-1][0], dp[i-1][2]);

                result = max(result, dp[i][0], dp[i][1], dp[i][2], dp[i][3], dp[i][4]);
            }

            return result;
        }

        private String key(int a, int b){
            return a+","+b;
        }

        private int max(int... input){
            int result = -1;
            for (int value : input) {
                if (value == -1) {
                    continue;
                }
                result = Math.max(result, value);
            }
            return result;
        }
    }

}
