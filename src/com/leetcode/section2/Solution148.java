package com.leetcode.section2;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * @author alexsong
 * @version $Id: Solution148.java, v 0.1 2017年12月08日 下午4:53:53 alexsong Exp $
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null)
        {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head2 = walker.next;
        walker.next = null;
        ListNode head1 = head;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }
    private ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode helper = new ListNode(0);
        helper.next = head1;
        ListNode pre = helper;
        while(head1!=null && head2!=null)
        {
            if(head1.val<head2.val)
            {
                head1 = head1.next;
            }
            else
            {
                ListNode next = head2.next;
                head2.next = pre.next;
                pre.next = head2;
                head2 = next;
            }
            pre = pre.next;
        }
        if(head2!=null)
        {
            pre.next = head2;
        }
        return helper.next;
    }

    protected void printList(ListNode head){
        while (head!=null){
            System.out.print(head.val);
            System.out.print("  ");
            head = head.next;
        }

        System.out.print('\n');

    }

    public static void main(String[] args){
        Solution148 s = new Solution148();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        s.printList(s.sortList(l1));

    }
}
