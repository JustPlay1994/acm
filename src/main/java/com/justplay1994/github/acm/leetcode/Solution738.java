package com.justplay1994.github.acm.leetcode;

/**
 * @author justplay1994
 * @date 2020-12-15 20:52
 */
public class Solution738 {

    public static void main(String[] args){
        new Solution738().new Solution().monotoneIncreasingDigits(10);
    }

    class Solution {
        public int monotoneIncreasingDigits(int N) {
        /*从高位到低位，找到第一个递减，借位
        如果是零，一定是上一个非零需要向后借位，因此不存在递减无法借位的情况，因为第一个高位一定是非0
        */
            if(N < 10){
                return N;
            }
            int result = 0;
            int last = -1;
            int i = 0;
            int _N = N;
            while(N  > 0){
                int temp = N % 10;
                if(last == -1){
                    last = temp;
                }else{
                    if(temp < last){
                        break;
                    }
                }
                i++;
                N = N / 10;
                System.out.println("1 " + i);
            }
            if(i == 0){
                return _N;
            }
            int j = 0;
            while(_N > 0){
                int temp = _N % 10;
                if(j < i){
                    result = result * 10 + 9;
                }else if(j == i){
                    result = result * 10 + temp - 1;
                }else{
                    result = result * 10 + temp;
                }
                j++;
                _N = _N / 10;
                System.out.println("2");
            }
            return result;
        }
    }
}
