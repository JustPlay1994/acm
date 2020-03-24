package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/12/20
 * 1172. 餐盘栈
 * start 11:21
 *
 */

public class Solution1172 {

    class DinnerPlates {

        private List<List<Integer>> stackList = new ArrayList<>();
        private int capacity = -1;

        private int leftNotFull = -1;   //需要调整的情况：1. 此栈新增且满了 2.左边删除了
        private int rightNotEmpty = -1; //需要调整的情况：1. 此栈删除且空了 2.右边新增了

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {

            List<Integer> stack = stackList.get(leftNotFull);
            stack.add(val);
            if (leftNotFull > rightNotEmpty){
                rightNotEmpty = leftNotFull;
            }
            if (stack.size() >= capacity) {
                int i = leftNotFull;
                leftNotFull = -1;
                for (; i < stackList.size(); i++) {
                    if (stackList.get(i).size() < capacity) {
                        leftNotFull = i;
                        break;
                    }
                }
                if (leftNotFull == -1){
                    stackList.add(new ArrayList<>());
                    leftNotFull = stackList.size() - 1;
                }
            }

        }

        public int pop() {
            int result = -1;
            if (rightNotEmpty == - 1){
                return result;
            }else {
                List<Integer> stack = stackList.get(rightNotEmpty);
                result = stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                if (stack.size() == 0){
                    int i = rightNotEmpty;
                    rightNotEmpty = -1;
                    for (; i >= 0; i--){
                        if (stackList.get(i).size() > 0 ){
                            rightNotEmpty = i;
                            break;
                        }
                    }
                }
            }
            return result;
        }

        public int popAtStack(int index) {
            int result = -1;
            List<Integer> stack = stackList.get(index);
            if (stack == null || stack.size() == 0) {
                return result;
            }else {
                result = stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                if (index < leftNotFull){
                    leftNotFull = index;
                }
                if (index == rightNotEmpty && stack.size() == 0){
                    int i = rightNotEmpty;
                    rightNotEmpty = -1;
                    for (; i >= 0; i--){
                        if (stackList.get(i).size() > 0 ){
                            rightNotEmpty = i;
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
}
