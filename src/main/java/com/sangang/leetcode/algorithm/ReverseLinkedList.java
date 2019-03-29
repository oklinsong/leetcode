package com.sangang.leetcode.algorithm;

/**
 * @author linsong
 * @date 2019/3/27 17:00
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 **/
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = ListNode.init();
        head = reverse(head);
        while (head != null) {
            System.out.println(head.getVal());
            head = head.getNext();
        }
        System.out.println("#########");
        ListNode head2 = ListNode.init();
        head2 = reverse2(head2);
        while (head2 != null) {
            System.out.println(head2.getVal());
            head2 = head2.getNext();
        }
    }


    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode reverse2(ListNode head) {
        if (head == null || head.getNext() == null) return head;
        ListNode p = reverse2(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return p;
    }
}
