package com.justplay1994.github.acm.leetcode;

/**
 * @author huangzezhou
 * @date 2020/3/23
 * 143. 重排链表
 * start 11:27
 * ac 15:41
 */

public class Solution143 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {

        ReverseNode tail;

        class ReverseNode{
            ListNode node;
            ReverseNode last;
            ReverseNode(ListNode node){
                this.node = node;
            }
        }

        public void reorderList(ListNode head) {
            if (head == null) return;
            tail = new ReverseNode(head);
            ListNode node = head;
            while (node.next != null){
                ReverseNode node1 = new ReverseNode(node.next);
                node1.last = tail;
                tail = node1;
                node = node.next;
            }
            while ( tail.node != head && head.next != tail.node){
                ListNode nextNode = head.next;
                head.next = tail.node;
                tail.node.next = nextNode;
                head = nextNode;
                tail = tail.last;
            }
            tail.node.next = null;
        }
    }

    public static void main(String[] args){
        int a = 2;
        int b =3;
        b = a = b = 10;
        System.out.println(a);
        System.out.println(b);
    }

}
