package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/27
 * 914. 卡牌分组
 * start 9:30
 */

public class Solution914 {
    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            int gcdV = 0;
            int max = 0;
            int[] num = new int[10001];
            for (int i = 0; i < deck.length; i++){
                num[deck[i]] += 1;
                max = Math.max(num[deck[i]], max);
            }
            for (int i = 0; i < num.length; i++){
                if (num[i] > 0){
                    if(gcdV == 0){
                        gcdV = num[i];
                    }else {
                        gcdV = gcd(gcdV, num[i]);
                        if (gcdV == 1)return false;
                    }
                }
            }
            return gcdV > 1;
        }

        public int gcd(int a, int b){
            if (Math.max(a,b) % Math.min(a, b) == 0) return Math.min(a, b);
            if (Math.max(a,b) % Math.min(a, b) == 1) return 1;
            return gcd(Math.max(a % b, b), Math.min(a % b, b));
        }
    }
}
