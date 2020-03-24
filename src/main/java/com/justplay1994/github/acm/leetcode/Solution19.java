package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/20
 * 19. 删除链表的倒数第N个节点
 * start 16:29
 * ac 16:36
 */

public class Solution19 {



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode slowParent = null;
            ListNode slow = head;
            ListNode fast = head;
            for (int i = 0; i < n - 1; i++){
                fast = fast.next;
            }
            while (fast.next != null){
                slowParent = slow;
                slow = slow.next;
                fast = fast.next;
            }
            if (slowParent == null){
                return slow.next;
            }else {
                slowParent.next = slow.next;
                return head;
            }
        }
    }
}
