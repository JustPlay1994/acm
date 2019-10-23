package com.justplay1994.github.acm.leetcode;

import com.justplay1994.github.acm.leetcode.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author huangzezhou
 * @date 2019/10/5
 * 211. 添加与搜索单词 - 数据结构设计
 */

/*
1. 前缀树，当char为字母时，按前缀树查找，当char为.时，直接按行找。
 */
public class Solution211 {

    static String input = "[\"WordDictionary\",\"addWord\",\"addWord\",\"addWord\",\"addWord\",\"search\",\"search\",\"addWord\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\"]\n" +
            "[[],[\"at\"],[\"and\"],[\"an\"],[\"add\"],[\"a\"],[\".at\"],[\"bat\"],[\".at\"],[\"an.\"],[\"a.d.\"],[\"b.\"],[\"a.d\"],[\".\"]]";

    public static void main(String[] args){
        String path = Solution211.class.getResource("/211.txt").getPath();
        File file = new File(path);
        input = FileUtil.file2String(file, "utf-8");

        long start = System.currentTimeMillis();

        long end = 0;

        WordDictionary d = new WordDictionary();
        input = input.replaceAll("\"","").replaceAll("\\[","").replaceAll("\\]","");
        String[] type = input.split("\n")[0].split(",");
        String[] strs = input.split("\n")[1].split(",");
        for (int i = 0; i < type.length; i++){
            switch (type[i]){
                case "addWord":
                    d.addWord(strs[i]);
                    System.out.println("null");
                    break;
                case "search":
                    end = end == 0 ? System.currentTimeMillis() : end;
                    System.out.println(d.search(strs[i]));
                    break;
            }
        }
        System.out.println(System.currentTimeMillis() - end);
        System.out.println(System.currentTimeMillis() - start);
    }

    static class WordDictionary {

        Node root;

        class Node {

            char val;
            List<Node> child;

            Node() {
            }

            Node(char val) {
                this.val = val;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
            root.child = new ArrayList<>();
        }


        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Node last = root;  //上一个字符
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                boolean isFound = false;
                List<Node> child = last.child;
                if (child != null) {
                    for (int j = 0; j < child.size(); j++) {
                        Node itNode = child.get(j);
                        if (itNode.val == c) {
                            last = itNode;
                            isFound = true;
                            child = last.child;
                            break;
                        }
                    }
                    if (!isFound) {
                        Node node = new Node(c);
                        child.add(node);
                        last = node;
                    }
                }else {
                    Node node = new Node(c);
                    last.child = new ArrayList<>();
                    last.child.add(node);
                    last = node;
                }
            }
            if (last.child == null) {
                last.child = new ArrayList<>();
            }
            last.child.add(new Node('N'));
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            LinkedBlockingDeque<Node> queue = new LinkedBlockingDeque<>();
            queue.add(root);
            queue.add(new Node('E'));
            //广度优先
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (i == word.length() - 1){
                    if (c != '.'){
                        Node node = queue.poll();
                        while (node != null  && node.val != 'E'){
                            if (node.child != null) {
                                for (int j = 0; j < node.child.size(); j++) {
                                    if (node.child.get(j).val == c) {
                                        for (int k = 0; k < node.child.get(j).child.size(); k++){
                                            if (node.child.get(j).child.get(k).val == 'N') return true;
                                        }
                                    }
                                }
                            }
                            node = queue.poll();
                        }
                    } else {
                        Node node = queue.poll();
                        while (node != null && node.val != 'E'){
                            for (int j = 0; j < node.child.size(); j++) {
                                if (node.child.get(j).val != 'N') {
                                    for (int k = 0; k < node.child.get(j).child.size(); k++){
                                        if (node.child.get(j).child.get(k).val == 'N') return true;
                                    }

                                }
                            }
                            node = queue.poll();
                        }
                    }
                    queue.add(new Node('E'));
                    if (queue.size() < 2)return false;
                }else {

                    if (c != '.') {
                        Node node = queue.poll();
                        while (node != null && node.val != 'E') {
                            if (node.child != null) {
                                for (int j = 0; j < node.child.size(); j++) {
                                    if (node.child.get(j).val == c) {
                                        queue.add(node.child.get(j));
                                    }
                                }
                            }
                            node = queue.poll();
                        }
                    } else {
                        Node node = queue.poll();
                        while (node != null && node.val != 'E') {
                            for (int j = 0; j < node.child.size(); j++) {
                                if (node.child.get(j).val != 'N') {
                                    queue.add(node.child.get(j));
                                }
                            }
                            node = queue.poll();
                        }
                    }
                    queue.add(new Node('E'));
                    if (queue.size() < 2) return false;
                }
            }
            Node node = queue.poll();
            while (node != null && node.val != 'E'){
               for (int i = 0; i < node.child.size(); i++){
                   if (node.child.get(i).val == 'N'){
                       return true;
                   }
               }
               node = queue.poll();
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
