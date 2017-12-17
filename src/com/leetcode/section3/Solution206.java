package com.leetcode.section3;

/**
 * Reverse a singly linked list.
 *
 * @author alexsong
 * @version $Id: Solution206.java, v 0.1 2017年12月17日 下午10:18:18 alexsong Exp $
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

        ListNode pPre = head;
        ListNode pCur = pPre.next;
        ListNode pNext = null;
        while (pCur != null){
            pNext = pCur.next;
            pCur.next = pPre;
            pPre = pCur;
            pCur = pNext;
        }

        head.next = null;

        head = pPre;

        return head;
    }
}
