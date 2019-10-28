package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/27
 * 147. 对链表进行插入排序
 * start 12:19
 *
 * 100 percent
 */

public class Solution147 {

    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode left = head;
            ListNode right = head.next;
            while (right != null && right.next != null) {
                left = left.next;
                right = right.next.next;
            }
            right = left.next;
            left.next = null;
            ListNode result = new ListNode(0);
            ListNode resultHead = result;
            ListNode leftNode = insertionSortList(head);
            ListNode rightNode = insertionSortList(right);
            while (leftNode != null && rightNode != null) {
                if (leftNode.val < rightNode.val) {
                    result.next = leftNode;
                    result = result.next;
                    leftNode = leftNode.next;
                } else {
                    result.next = rightNode;
                    result = result.next;
                    rightNode = rightNode.next;
                }
            }
            result.next = leftNode == null ? rightNode : leftNode;
            return resultHead.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
