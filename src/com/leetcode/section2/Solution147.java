package com.leetcode.section2;

/**
 * Sort a linked list using insertion sort.
 *
 * @author alexsong
 * @version $Id: Solution147.java, v 0.1 2017年12月08日 下午3:15:15 alexsong Exp $
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;

        ListNode p = head.next;
        head.next = null;

        while (p != null){
            ListNode t = p;
            p = p.next;
            t.next = null;
            head = this.insert(head, t);
        }
        return head;
    }

    protected ListNode insert(ListNode head, ListNode t){
        if(t.val < head.val){
            t.next = head;
            head = t;

            return head;
        }

        ListNode p = head;

        while(p.next != null){
            if(p.next.val > t.val){
                t.next = p.next;
                p.next = t;
                return head;
            }
            p = p.next;
        }

        p.next = t;

        return head;
    }
}
