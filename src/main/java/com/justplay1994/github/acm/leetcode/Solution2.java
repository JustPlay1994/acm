package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2019/10/23
 * 2. 两数相加
 * start 20:20
 * ac 20:59
 */

public class Solution2 {

    // 65 + 97
    public static void main(String[] args){
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(9);
        new Solution().addTwoNumbers(l1,l2);
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int right;
            int left = 0;
            ListNode temp = null;
            ListNode result=null;
            while (l1 != null || l2 != null){
                if (l1 == null){
                    right = l2.val;
                }else if (l2 == null){
                    right = l1.val;
                }else {
                    right = (l1.val + l2.val) % 10;
                }

                if (temp == null) {
                    result = temp = new ListNode(right + left);
                }else {
                    temp.next = new ListNode(right + left);
                    temp = temp.next;
                }

                if (l1 == null){
                    left = 0;
                    l2 = l2.next;
                }else if (l2 == null){
                    left = 0;
                    l1 = l1.next;
                } else {
                    left = (l1.val + l2.val) / 10;
                    l1 = l1.next;
                    l2 = l2.next;
                }

                if (temp.val == 10){
                    temp.val = 0;
                    left++;
                }
            }
            if (left > 0){
                temp.next = new ListNode(left);
            }
            return result;
        }
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

}
