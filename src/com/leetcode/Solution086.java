package com.leetcode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * @author alexsong
 * @version $Id: Solution086.java, v 0.1 2017年11月27日 下午6:14:14 alexsong Exp $
 */
public class Solution086 {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        if(head.val<x)
            head.next = partition(head.next, x);
        else{
            ListNode p = head;
            ListNode q = head;
            while (q!= null && q.val >= x) {
                p = q;
                q = q.next;
            }

            if(q == null)
                return head;
            else {
                p.next = q.next;
                q.next = head;
                head = q;
                head.next = partition(q.next, x);
            }
        }
        return  head;
    }
}
