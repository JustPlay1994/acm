package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/23
 * 876. 链表的中间结点
 * start 11:00
 * ac 11:20
 */

public class Solution876 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null && slow.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
