package com.justplay1994.github.acm.leetcode;

import java.math.BigInteger;

/**
 * @author huangzezhou
 * @date 2019/9/1
 * 5173.质数排列
 */

public class Solution5173AC {

    public static void main(String[] args){
        System.out.println(new Solution5173AC().numPrimeArrangements(100));
    }

    public int numPrimeArrangements(int n) {
        int numZ = 0;
        for (int i = 1; i <= n; i++){
            if (isZ(i)) numZ++;
        }
        return conbime(numZ) .multiply( conbime(n-numZ)).mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public boolean isZ(int num){
        if (num < 2) return false;
        for (int i = 2; i < num; i++){
            for (int j = i; i * j <= num; j++){
                if (i * j == num) return false;
            }
        }
        return true;
    }

    public BigInteger conbime(int n){
        BigInteger result = BigInteger.valueOf(1);
        for (int i = n; i >= 1; i--){
            result = result.multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(1000000007));
        }
        return result.mod(BigInteger.valueOf(1000000007));
    }
}
