package com.justplay1994.github.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzezhou
 * @date 2020/3/10
 * 939. 最小面积矩形
 * start 19:38
 *
 */

public class Solution939 {
    class Solution {
        //先形成 十字链表。
        //矩阵第一点,4个方向,第二点，两个方向，第三、第四点，一个方向。 共8种情况。最大500*8
        //每次加入一个点，然后判断与这个点形成的矩形最小面积，作为遍历维度
        public int minAreaRect(int[][] points) {
            Node[] array = new Node[points.length];
            for (int i = 0; i < points.length; i++){
                //新节点
                Node node = new Node(points[i][0], points[i][1]);
                //找到每个方向，最靠近的点。
                for (int j = 0; j < i; j++){
                    //老节点
                    Node temp = array[j];
                    //横向
                    if (temp.y == node.y){
                        //左节点
                        if (temp.x < node.x) {
                            if (node.left == null) {
                                node.left = temp;

                            } else {
                                //比左节点，偏右
                                if (temp.x > node.left.x){
                                    node.left.right = temp;
                                    temp.right = node;
                                    node.left = temp;
                                }
                            }
                        }else {//没有相同点，一定是右节点
                            if (node.right == null){
                                node.right = temp;
                            }else {
                                if (temp.x < node.right.x){
                                    node.right.left = temp;
                                    temp.left = node;
                                    node.right = temp;
                                }
                            }
                        }
                    }
                    //纵向
                    if (temp.x == node.x){
                        //上节点
                        if (temp.y > node.y){
                            if (node.up == null){

                            }
                        }
                    }
                }
            }
            return 0;
        }
        class Node{
            public int x;
            public int y;
            public Node up;
            public Node down;
            public Node left;
            public Node right;
            Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
    }
}
