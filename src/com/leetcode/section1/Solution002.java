package com.leetcode.section1;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * @author alexsong
 * @version $Id: Solution002.java, v 0.1 2017年11月21日 下午12:59:59 alexsong Exp $
 */
public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l2 == null)
            return l1;
        else if(l1 == null)
            return addTwoNumbers(l2,l1);
        else
        {
            int i = (l1.val+l2.val)%10;
            int j = (l1.val+l2.val)/10;
            l1.val = i;
            if(j == 1)
            {
                //有进位
                ListNode newNode = new ListNode(0);
                newNode.val = 1;
                l1.next=addTwoNumbers(addTwoNumbers(l1.next, newNode),l2.next);
            }
            else
                l1.next = addTwoNumbers(l1.next,l2.next);

            return l1;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){this.val =x;}
}
