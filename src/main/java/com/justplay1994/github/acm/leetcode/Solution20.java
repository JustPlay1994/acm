package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 20. 有效的括号
 * start 11:38
 * ac 11:50
 */

public class Solution20 {

    class Solution {
        public boolean isValid(String s) {
            List<Integer> list = new ArrayList<>();
            char[] a = s.toCharArray();
            for (int i = 0; i < a.length; i++){
                if (list.size() > a.length - i){
                    return false;
                }
                int c = a[i];
                if (list.size() == 0){
                    list.add(c);
                }else {
                    switch (c){
                        case ')':
                            if (list.get(list.size() - 1) == '('){
                                list.remove(list.size() - 1);
                            }else {
                                return false;
                            }
                            break;
                        case '}':
                            if (list.get(list.size() - 1) == '{'){
                                list.remove(list.size() - 1);
                            }else {
                                return false;
                            }
                            break;
                        case ']':
                            if (list.get(list.size() - 1) == '['){
                                list.remove(list.size() - 1);
                            }else {
                                return false;
                            }
                            break;
                        default:
                            list.add(c);
                            break;
                    }
                }
            }
            return list.size() <= 0;
        }
    }

}
