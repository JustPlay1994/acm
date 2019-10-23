package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/9
 * 780. 到达终点
 */

public class Solution780 {

    public static void main(String[] args){
//        new Solution().reachingPoints(1,6,999999997,6);
//        new Solution().reachingPoints(10, 5, 15, 5);
        new Solution().reachingPoints(3,7,3,4);
    }

    static class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            while (true){
                if (tx < sx || ty < sy)return false;
                if (tx == ty){
                    return tx == sx && ty == sy;
                }
                else if (tx > ty){
                    int k = (tx - Math.max(ty, sx)) / ty;
                    k = k == 0 ? 1 : k;
                    tx -= k * ty;
                    if (tx == sx && ty == sy) return true;
                }else {
                    int k = (ty - Math.max(tx, sy)) / tx;
                    k = k == 0 ? 1 : k;
                    ty -= k * tx;
                    if (tx == sx && ty == sy) return true;
                }
                if (tx < sx || ty < sy)return false;
            }
        }
    }

}
