package com.sangang.leetcode.algorithm;

/**
 * @author linsong
 * @date 2019/3/27 17:00
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 **/
public class Question206 {

    public static void main(String[] args) {
        ListNode head = ListNode.init();
        head = reverse(head);
        while (head != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
        System.out.println();
        ListNode head2 = ListNode.init();
        head2 = reverse2(head2);
        while (head2 != null) {
            System.out.print(head2.getVal() + " ");
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

class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    static ListNode init() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;
        return head;
    }
}
