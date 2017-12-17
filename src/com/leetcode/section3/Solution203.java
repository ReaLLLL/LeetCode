package com.leetcode.section3;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * @author alexsong
 * @version $Id: Solution203.java, v 0.1 2017年12月17日 下午9:52:52 alexsong Exp $
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == val) pointer.next = pointer.next.next;
            else pointer = pointer.next;
        }
        return head.val == val ? head.next : head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
