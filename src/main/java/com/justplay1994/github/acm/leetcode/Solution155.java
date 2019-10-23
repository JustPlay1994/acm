package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2019/9/16
 * <p>
 * 155.最小栈
 */

public class Solution155 {

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        s.getMin();
        s.pop();
        s.top();
        s.getMin();
    }

}

class MinStack {

    Integer min;

    List<Node> list;

    class Node{

        /**
         * 值
         */
        int value;

        /**
         * 上一个节点
         */
        Node last;

        Node(int value, Node last){
            this.value = value;
            this.last = last;
        }
    }

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        if (list.size() == 0){
            list.add(new Node(x, null));
        }else {
            list.add(new Node(x, list.get(list.size() - 1)));
        }
        if (min != null){
            min = min < x ? min : x;
        }
    }

    public void pop() {
        if (min != null) {
            int value = list.get(list.size() - 1).value;
            if (min == value) min = null;
        }
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1).value;
    }

    public int getMin() {
        if(min != null)return min;
        int min = Integer.MAX_VALUE;
        for (Node node: list){
            min = min < node.value ? min : node.value;
        }
        return min;
    }
}


