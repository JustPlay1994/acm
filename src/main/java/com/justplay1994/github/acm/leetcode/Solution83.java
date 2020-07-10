package com.justplay1994.github.acm.leetcode;

import java.util.HashSet;

/**
 * 2020/05/15 16:13
 * 83. 删除排序链表中的重复元素
 * ac 16:18
 */
public class Solution83 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode temp = head.next;
            ListNode last = head;
            HashSet<Integer> set = new HashSet<>();
            set.add(head.val);
            while (temp != null){
                if (!set.contains(temp.val)){
                    set.add(temp.val);
                    last = last.next;
                }else {
                    last.next = temp.next;
                }
                temp = temp.next;
            }
            return head;
        }
    }
}
