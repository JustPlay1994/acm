package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/27
 * 148. 排序链表
 * start 13:29
 * end 14:20
 * one time
 */

public class Solution148 {



    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode left = head;
            ListNode right = head.next;
            while (right != null && right.next != null){
                left = left.next;
                right = right.next.next;
            }
            right = left.next;
            left.next = null;
            ListNode result = null;
            ListNode resultHead = null;
            ListNode leftNode = sortList(head);
            ListNode rightNode = sortList(right);
            while (leftNode != null && rightNode != null){
                if (leftNode.val < rightNode.val){
                    if (result != null) {
                        result.next = leftNode;
                        result = result.next;
                    }else {
                        result = leftNode;
                        resultHead = result;
                    }
                    leftNode = leftNode.next;
                }else {
                    if (result != null) {
                        result.next = rightNode;
                        result = result.next;
                    }else {
                        result = rightNode;
                        resultHead = result;
                    }
                    rightNode = rightNode.next;
                }
            }
            result.next = leftNode == null ? rightNode : leftNode;
            return resultHead;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
