package com.leetcode.section2;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * @author alexsong
 * @version $Id: Solution141.java, v 0.1 2017年12月07日 下午5:38:38 alexsong Exp $
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;

        if (head.next == null)
            return false;

        ListNode l1 = head, l2 = head;

        while (null != l2){
            l1 = l1.next;
            if(l2.next != null)
                l2 = l2.next.next;
            else
                return false;

            if(l1 == l2)
                return true;
        }

        return false;
    }
}
