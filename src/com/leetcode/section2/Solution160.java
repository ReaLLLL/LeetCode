package com.leetcode.section2;

/*
* Write a program to find the node at which the intersection of two singly linked lists begins.
* */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = this.getListLength(headA);
        int lenB = this.getListLength(headB);

        if(lenA * lenB == 0)
            return null;

        ListNode t1 = headA;
        ListNode t2 = headB;

        if(lenA >= lenB){
            while (lenA > lenB){
                t1 = t1.next;
                lenA --;
            }
        }else {
            while (lenB > lenA){
                t2 = t2.next;
                lenB --;
            }
        }

        while (t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;

    }

    protected int getListLength(ListNode list){
        if(list == null)
            return 0;

        return getListLength(list.next) + 1;
    }
}
