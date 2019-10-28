package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/27
 * 21. 合并两个有序链表
 *
 * start 14:21
 * end 14:25
 * one time
 */

public class Solution21 {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode resultHead = new ListNode(0);
            ListNode result = resultHead;
            while (l1 != null && l2 != null){
                if (l1.val < l2.val){
                    result.next = l1;
                    result = result.next;
                    l1 = l1.next;
                }else {
                    result.next = l2;
                    result = result.next;
                    l2 = l2.next;
                }
            }
            result.next = l1 == null ? l2 : l1;
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
