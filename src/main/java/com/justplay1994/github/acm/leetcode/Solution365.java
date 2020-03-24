package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/11/5
 * 365. 水壶问题
 * start 10:30
 */

/*
假设 y > x
d 为 当前容量

d = y - x
if(y - x < x) d = 2y - 2x
if(2y - 2x < x) d = 3y - 3x
if(3y - 3x < x) d = 4y - 4x

if( x + d < y) d = x + d;
if( 2x + d < y） d = 2x + d;

if(x + d > y) d = x + d - y


*/
public class Solution365 {

    public static void main(String[] args){
        new Solution().canMeasureWater(6, 9, 1);
    }

    static
    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            if (x ==0 || y==0){
                return z == 0;
            }
            return z % gcd(x, y) == 0
                    && z <= x + y;
        }

        public int gcd(int x, int y){
            int mod = Math.max(x, y) % Math.min(x, y);
            if (mod == 0){
                return Math.min(x, y);
            }else {
                return gcd(mod, Math.min(x, y));
            }
        }


        public int gcd1(int x, int y){
            int z = Math.max(x,y) - Math.min(x, y);
            if (z == 0){
                return x;
            }else {
                return gcd1(z, Math.min(x, y));
            }
        }
    }

}
