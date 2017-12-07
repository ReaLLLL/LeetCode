package com.leetcode.section2;

/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * @author alexsong
 * @version $Id: Solution142.java, v 0.1 2017年12月07日 下午6:00:00 alexsong Exp $
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;

        if (head.next == null)
            return null;

        ListNode l1 = head, l2 = head;
        int i = 0, j = 0;

        while (null != l2){
            l1 = l1.next;
            i++;
            if(l2.next != null) {
                l2 = l2.next.next;
                j+=2;
            }
            else
                return null;

            if(l1 == l2) {
                int diff = j - i;
                l1 = head;
                l2 = head;

                while (diff>0) {
                    l2 = l2.next;
                    diff--;
                }

                while (l1 != l2){
                    l1 = l1.next;
                    l2 = l2.next;
                }

                return l1;
            }
        }
        return null;
    }
}
