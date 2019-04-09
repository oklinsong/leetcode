package com.sangang.leetcode.algorithm;

/**
 * @author linsong
 * @date 2019/3/28 15:12
 **/

public class Question24 {
    public static void main(String[] args) {
        ListNode head = ListNode.init();
        head = swapNode(head);
        while (head != null) {
            System.out.print(head.getVal()+" ");
            head = head.getNext();
        }
    }

    public static ListNode swapNode(ListNode head) {
        ListNode dump = new ListNode(0);
        dump.setNext(head);
        head = dump;
        while (head.getNext() != null
                && head.getNext().getNext() != null) {
            ListNode n1 = head.getNext();
            ListNode n2 = head.getNext().getNext();
            head.setNext(n2);
            n1.setNext(n2.getNext());
            n2.setNext(n1);
            head = n1;
        }
        return dump.getNext();
    }


}
