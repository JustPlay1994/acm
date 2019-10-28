package com.justplay1994.github.acm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author huangzezhou
 * @date 2019/10/25
 * 677. 键值映射
 * start: 9:33
 * pause: 9:49
 * start: 10:00
 * ac: 10:46
 */

/*
Hash存储数据，覆盖操作O(1)
前缀树存储key前缀，查找前缀操作O（logN）
 */
public class Solution677 {

    public static void main(String[] args){
        MapSum mapSum = new MapSum();
        mapSum.insert("abc",1);
        System.out.println(mapSum.sum("ab"));
        mapSum.insert("abcd", 1);
        System.out.println(mapSum.sum("ab"));
        mapSum.insert("ab", 1);
        System.out.println(mapSum.sum("ab"));
        mapSum.insert("abc", 100);
        System.out.println(mapSum.sum("ab"));
    }

    static class MapSum {

        class TreeNode{
            HashMap<Integer, TreeNode> children;    //存储前缀，一个字符
            Integer val = null;
        }


        TreeNode root = null;
        HashMap<String, TreeNode> map = new HashMap<>();

        /** Initialize your data structure here. */
        public MapSum() {
            root = new TreeNode();
        }

        public void insert(String key, int val) {
            if (map.get(key) != null && map.get(key).val != null){
                TreeNode node = map.get(key);
                node.val = val;
                return;
            }
            TreeNode node = root;
            for (int i = 0; i < key.length(); i++){
                if (node.children == null){
                    node.children = new HashMap<>();
                }
                TreeNode temp = node.children.get((int) key.charAt(i));
                if (temp == null){
                    temp = new TreeNode();
                    node.children.put((int) key.charAt(i), temp);
                }
                if (i != key.length() - 1) {
                    node = temp;
                }else {
                    temp.val = val;
                }
            }

        }

        public int sum(String prefix) {
            TreeNode node = root;
            for (int i = 0; i < prefix.length(); i++){
                if (node != null && node.children != null) {
                    node = node.children.get((int) prefix.charAt(i));
                }else {
                    return 0;
                }
            }
            return sumTreeNode(node, 0);
        }

        /**
         * 计算当前node，以及其孩子节点的总和
         * @param node
         * @return
         */
        public int sumTreeNode(TreeNode node, int result){
            if (node == null){
                return 0;
            }
            if (node.val != null){
                result += node.val;
            }
            if (node.children == null){
                return result;
            }
            for (Map.Entry<Integer, TreeNode> child: node.children.entrySet()){
                result += sumTreeNode(child.getValue(), 0);
            }
            return result;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
