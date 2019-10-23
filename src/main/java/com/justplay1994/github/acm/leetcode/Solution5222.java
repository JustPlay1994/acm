package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/13
 * 5222. 分割平衡字符串
 */

public class Solution5222 {

    class Solution {
        public int balancedStringSplit(String s) {
            int num=0;  //正表示L
            int result = 0;
            for(int i = 0; i < s.length(); i++){

                if(s.charAt(i) == 'L'){
                    num++;
                }else{
                    num--;
                }
               if (num == 0){
                   result++;
               }
            }
            return result;
        }
    }
}
