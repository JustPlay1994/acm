package com.justplay1994.github.acm.leetcode;

/**
 * Created by JustPlay1994 on 2019/4/27.
 * https://github.com/JustPlay1994
 */

import java.util.HashMap;

/**
 * LRU缓存机制
 * 设计思路如下O(1)：
 * hash表，统计被访问次数
 *
 */
public class Solution146None {

    int capacity = 0;
    HashMap data;



    public Solution146None(int capacity) {
        this.capacity = capacity;
        data = new HashMap(capacity);
    }

    public int get(int key) {
        data.get(key);
        return -1;
    }

    public void put(int key, int value) {

    }

    /**
     * 小顶堆:
     */
    class MinHeap{

        Node root;

        class Node{
            int data;
            Node parent;
            Node leftChild;
            Node rightChild;

            public Node(){

            }

            public Node(int data, Node parent, Node leftChild, Node rightChild){

            }
        }

        public int pop(){
            if (root == null){
                return -1;
            }
            int result = root.data;
            if (root.leftChild == null ^ root.rightChild == null){
                root = root.leftChild == null ? root.rightChild : root.leftChild;
            }else if (root.leftChild !=null && root.rightChild!=null){
                if (root.leftChild.data <= root.rightChild.data){
                    root.rightChild.parent = root.leftChild;
                    root.leftChild.parent = null;



                }
            }


            return result;
        }

        public void push(int d){
            if (root == null){
                root = new Node(d, null, null, null);
            }else {
                Node node = root;
                while (true){
                    if ( d <=  node.data){
                        Node temp = new Node(d, node.parent, node, node.rightChild);
                        node.parent = temp;
                        if (node.rightChild != null){
                            node.rightChild.parent = temp;
                        }
                    }
                }
            }
        }

    }




}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
